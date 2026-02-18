package com.github.marcellgalves.cadastroapi.Missoes;

import com.github.marcellgalves.cadastroapi.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficult;

     // @OneToMany - Uma missão pode ter vários ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;


    public MissoesModel(Long id, String name, String difficult) {
        this.id = id;
        this.name = name;
        this.difficult = difficult;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDifficult() {
        return difficult;
    }
    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }
}
