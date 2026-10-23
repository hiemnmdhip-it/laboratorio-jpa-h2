package org.zabalburu.laboratorio_jpa_h2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "item_prompts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 30)
    private String categoria; // "ARTE", "CODIGO", "MARKETING"

    @Column(nullable = false)
    private Integer creditos;

    @Column(nullable = false)
    private Boolean activo;

    // Constructor de conveniencia sin ID (para inserciones)
    public ItemPrompt(String titulo, String categoria, Integer creditos, Boolean activo) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.creditos = creditos;
        this.activo = activo;
    }
}