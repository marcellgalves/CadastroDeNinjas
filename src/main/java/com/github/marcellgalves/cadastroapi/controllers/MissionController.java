package com.github.marcellgalves.cadastroapi.controllers;


import com.github.marcellgalves.cadastroapi.models.MissoesModel;
import com.github.marcellgalves.cadastroapi.services.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissionController {

    private final MissionService service;

    // Injeção via construtor
    public MissionController(MissionService service) {
        this.service = service;
    }

                // C.R.U.D

    // CREATE
    @PostMapping("/cadastrar")
    public MissoesModel cadastrarMissao(@RequestBody MissoesModel missao) {
        return service.cadastrarMissao(missao);
    }

    // READ
    @GetMapping("/show/{id}")
    public Optional<MissoesModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
    @GetMapping("/list-all")
    public List<MissoesModel> listar(){
        return service.listarMissoes();
    }

    // UPDATE
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missao) {
        return service.atualizarMissao(id, missao);
    }

    // DELETAR
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        service.deletarMissao(id);
    }






}
