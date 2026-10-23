package org.zabalburu.laboratorio_jpa_h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zabalburu.laboratorio_jpa_h2.model.ItemPrompt;

@Repository
public interface ItemPromptRepository extends JpaRepository<ItemPrompt, Long> {

	/* Búsqueda exacta de todos los prompts de una categoría dado su nombre
Búsqueda de los prompts de una categoría dada, que esté activa y con créditos menor o igual a los que nos indiquen
Búsqueda de los prompts de una categoría cuyo título incluya un texto dado
Consulta personalizada con JPQL que busque los prompts entre dos créditos ordenados en descendente por créditos*/
	List<ItemPrompt> findByCategoriaIgnoreCaseAndActivoTrueAndCreditosLessThanEqual(String categoria, Integer creditos);

	List<ItemPrompt> findByCategoriaIgnoreCaseAndTituloContainingIgnoreCase(String categoria, String texto);
	
	List<ItemPrompt> findByCategoriaIgnoreCase(String categoria);
	

    @Query("""
    		SELECT ip FROM ItemPrompt ip 
    		WHERE ip.creditos 
    		BETWEEN :min AND :max 
    		ORDER BY ip.creditos DESC
    		""")
    List<ItemPrompt> buscarPorCreditosDescendete(
        @Param("min") Integer minCreditos, 
        @Param("max") Integer maxCreditos
    );
    
    @Query("""
    		SELECT ip.categoria FROM ItemPrompt ip
    		ORDER BY ip.categoria	
    		""")
    List<String> getByCategoriaSorted();
	
	
	}


