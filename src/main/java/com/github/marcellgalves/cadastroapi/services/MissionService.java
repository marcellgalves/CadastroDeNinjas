package com.github.marcellgalves.cadastroapi.services;

import com.github.marcellgalves.cadastroapi.models.MissoesModel;
import com.github.marcellgalves.cadastroapi.exceptions.MissionNotFoundException;
import com.github.marcellgalves.cadastroapi.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    // Listar todos as missões
    public List<MissoesModel> listarMissoes() {
        return missionRepository.findAll();
    }

    // Salvar um ninja
    public MissoesModel cadastrarMissao(MissoesModel missao) {
        return missionRepository.save(missao);
    }

    // Buscar por ID
    public Optional<MissoesModel> buscarPorId(Long id) {
        return missionRepository.findById(id);
    }

    // Deletar
    public void deletarMissao(Long id) {
        missionRepository.deleteById(id);
    }

    // Atualizar
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada) {
        // Verificamos se o ninja existe antes de tentar "salvar por cima"
        if (missionRepository.existsById(id)) {
            missaoAtualizada.setId(id); // ESSA LINHA É A CHAVE! Dizemos ao objeto qual ID ele deve assumir
            return missionRepository.save(missaoAtualizada); // O .save() agora fará um UPDATE
        } else {
            throw new MissionNotFoundException("Ninja não encontrado para atualizar.");
        }
    }
}
