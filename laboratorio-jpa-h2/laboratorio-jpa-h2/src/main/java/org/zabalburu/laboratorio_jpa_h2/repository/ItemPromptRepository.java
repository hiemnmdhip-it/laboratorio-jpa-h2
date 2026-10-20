package org.zabalburu.laboratorio_jpa_h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.laboratorio_jpa_h2.model.ItemPrompt;

public interface ItemPromptRepository extends JpaRepository<ItemPrompt, Long> {

	/* Búsqueda exacta de todos los prompts de una categoría dado su nombre
Búsqueda de los prompts de una categoría dada, que esté activa y con créditos menor o igual a los que nos indiquen
Búsqueda de los prompts de una categoría cuyo título incluya un texto dado
Consulta personalizada con JPQL que busque los prompts entre dos créditos ordenados en descendente por créditos*/
	List<ItemPrompt> findByCategoriaAndActivoTrueAndCreditosLessThanEqual(String categoria, int maxCreditos);

	List<ItemPrompt> findByCategoriaAndTituloContainingIgnoreCase(String categoria, String texto);
	
	}
