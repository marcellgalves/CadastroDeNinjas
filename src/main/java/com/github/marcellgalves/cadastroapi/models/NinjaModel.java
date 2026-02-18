package com.github.marcellgalves.cadastroapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity -- Class -> Entity
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O nome não pode ser vazio.")
    private String name;

    @Email (message = "O email deve ser válido. ")
    private String email;
    private int age;

     // @ManyToOne - um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira.
    @JsonBackReference
    private MissoesModel missoes;

}
