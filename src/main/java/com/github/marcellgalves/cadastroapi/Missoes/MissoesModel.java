package com.github.marcellgalves.cadastroapi.Missoes;

import com.github.marcellgalves.cadastroapi.Ninjas.NinjaModel;
import jakarta.persistence.*;
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
    private String name;
    private String difficult;

     // @OneToMany - Uma missão pode ter vários ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
