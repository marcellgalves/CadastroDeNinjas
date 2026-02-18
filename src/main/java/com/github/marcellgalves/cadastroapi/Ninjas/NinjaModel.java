package com.github.marcellgalves.cadastroapi.Ninjas;

import com.github.marcellgalves.cadastroapi.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String name;
    private String email;
    private int age;

     // @ManyToOne - um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira.
    private MissoesModel missoes;

}
