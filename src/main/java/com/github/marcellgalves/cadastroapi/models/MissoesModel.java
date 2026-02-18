package com.github.marcellgalves.cadastroapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome da missão não pode ser vazio.")
    private String name;
    @NotBlank(message = "A missão deve ter uma dificuldade definida.")
    private String difficult;

     // @OneToMany - Uma missão pode ter vários ninjas.
    @OneToMany(mappedBy = "missoes", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<NinjaModel> ninjas;

}
