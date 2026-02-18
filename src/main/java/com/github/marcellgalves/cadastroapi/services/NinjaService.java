package com.github.marcellgalves.cadastroapi.services;

import com.github.marcellgalves.cadastroapi.exceptions.RestExceptionHandler;
import com.github.marcellgalves.cadastroapi.models.NinjaModel;
import com.github.marcellgalves.cadastroapi.exceptions.NinjaNotFoundException;
import com.github.marcellgalves.cadastroapi.repository.NinjaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NinjaService{

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

     // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

     // Salvar um ninja
     public NinjaModel cadastrarNinja(NinjaModel ninja) {
         log.info("Cadastrando novo ninja: {}", ninja.getName());
         return ninjaRepository.save(ninja);
     }
     // Buscar por ID
     public NinjaModel buscarPorId(Long id) {
         log.info("Buscando ninja com ID: {}", id);
         return ninjaRepository.findById(id)
                 .orElseThrow(() -> new NinjaNotFoundException("Ninja não encontrado com o ID: " + id));
     }

     // Deletar
     public void deletarNinja(Long id) {
         if (ninjaRepository.existsById(id)) {
             log.info("Deletando ninja com ID: {}", id);
             ninjaRepository.deleteById(id);
         } else {
             log.warn("Falha ao deletar: ID {} não existe", id);
             throw new NinjaNotFoundException("Não foi possível deletar: Ninja não encontrado.");
         }
     }

    // Atualizar
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        // Verificamos se o ninja existe antes de tentar "salvar por cima"
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id); // ESSA LINHA É A CHAVE! Dizemos ao objeto qual ID ele deve assumir
            return ninjaRepository.save(ninjaAtualizado); // O .save() agora fará um UPDATE
        } else {
            throw new NinjaNotFoundException("Ninja não encontrado com o ID: " + id);
        }
    }
}
