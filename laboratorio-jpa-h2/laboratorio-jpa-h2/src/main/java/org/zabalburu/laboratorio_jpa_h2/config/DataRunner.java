package org.zabalburu.laboratorio_jpa_h2.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zabalburu.laboratorio_jpa_h2.model.ItemPrompt;
import org.zabalburu.laboratorio_jpa_h2.repository.ItemPromptRepository;

@Component
public class DataRunner implements CommandLineRunner {

    private final ItemPromptRepository repository;

    public DataRunner(ItemPromptRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== 1. POBLANDO BASE DE DATOS H2 ===");
        repository.saveAll(List.of(
            new ItemPrompt("Generador Cyberpunk", "ARTE", 15, true),
            new ItemPrompt("Optimizador SQL", "CODIGO", 30, true),
            new ItemPrompt("Copywriting LinkedIn", "MARKETING", 10, false),
            new ItemPrompt("Pixel Art Maker", "ARTE", 25, true),
            new ItemPrompt("Refactor Clean Code", "CODIGO", 45, true)
        ));

        System.out.println("\n== Prueba findByCategoriaIgnoreCase ==");
        System.out.println("1. Buscando arte:");
        mostrarLista(repository.findByCategoriaIgnoreCase("ARTE"));

        System.out.println("\n2. Buscando publicidad:");
        mostrarLista(repository.findByCategoriaIgnoreCase("PUBLICIDAD"));
    }
    
    private void mostrarLista(List<ItemPrompt> lista) {
        if (lista.isEmpty()) {
            System.out.println("(Lista vacía)");
            return;
        }
        System.out.println(lista.stream()
                .map(ip -> "[%s,%s,%b,%d]".formatted(ip.getTitulo(),
                        ip.getCategoria(),
                        ip.getActivo(),
                        ip.getCreditos()))
                .collect(Collectors.joining(",\n")));
    }
}
