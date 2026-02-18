package com.github.marcellgalves.cadastroapi.controllers;

import com.github.marcellgalves.cadastroapi.models.NinjaModel;
import com.github.marcellgalves.cadastroapi.services.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService service;

    // Injeção via construtor
    public NinjaController(NinjaService service) {
        this.service = service;
    }

                       // C.R.U.D

     // CREATE
    @PostMapping("/cadastrar")
    public NinjaModel cadastrarNinja(@RequestBody NinjaModel ninja) {
        return service.cadastrarNinja(ninja);
    }

     // READ
    @GetMapping("/show/{id}")
    public Optional<NinjaModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
     @GetMapping("/list-all")
     public List<NinjaModel> listar(){
         return service.listarNinjas();
     }

      // UPDATE
      @PutMapping("/alterar/{id}")
      public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninja) {
          return service.atualizarNinja(id, ninja);
      }

     // DELETAR
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id) {
        service.deletarNinja(id);
    }

}
