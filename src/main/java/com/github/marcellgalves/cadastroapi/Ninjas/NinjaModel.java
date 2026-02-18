package com.github.marcellgalves.cadastroapi.Ninjas;

import com.github.marcellgalves.cadastroapi.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// Entity -- Class -> Entity
@Entity
@Table(name = "tb_cadastro")
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


    public NinjaModel() {
    }
    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



}
