package com.github.marcellgalves.cadastroapi.services;

import com.github.marcellgalves.cadastroapi.models.MissoesModel;
import com.github.marcellgalves.cadastroapi.exceptions.MissionNotFoundException;
import com.github.marcellgalves.cadastroapi.repository.MissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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
        try {
            log.info("Iniciando cadastro da missão: {} [Dificuldade: {}]", missao.getName(), missao.getDifficult());

            MissoesModel missaoSalva = missionRepository.save(missao);

            log.info("Missão cadastrada com sucesso! ID gerado: {}", missaoSalva.getId());
            return missaoSalva;

        } catch (Exception e) {
            // Aqui o catch serve para REGISTRAR o erro no console antes de explodir
            log.error("Erro fatal ao cadastrar missão '{}': {}", missao.getName(), e.getMessage());

            // Você lança o erro de novo para que o RestExceptionHandler capture
            throw e;
        }
    }

    // Buscar por ID
    public MissoesModel buscarPorId(Long id) {
        log.info("Buscando missão com ID: {}", id);
        return missionRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Missão com ID {} não encontrada.", id);
                    return new MissionNotFoundException("Missão não encontrada com o ID: " + id);
                });
    }

    // Deletar
    public void deletarMissao(Long id) {
        if (missionRepository.existsById(id)) {
            log.info("Deletando missão ID: {}", id);
            missionRepository.deleteById(id);
        } else {
            // Em vez de catch, você LANÇA a exceção aqui
            log.error("Erro ao deletar: ID {} não existe.", id);
            throw new MissionNotFoundException("Impossível deletar: Missão inexistente.");
        }
    }

    // Atualizar
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada) {
        log.info("Solicitação para atualizar missão ID: {}", id); // 1. Log de entrada

        if (missionRepository.existsById(id)) {
            log.info("Missão encontrada. Salvando alterações para: {}", missaoAtualizada.getName()); // 2. Log de sucesso
            missaoAtualizada.setId(id);
            return missionRepository.save(missaoAtualizada);
        } else {
            log.warn("Falha na atualização: ID {} não existe no banco.", id); // 3. Log de aviso
            // Corrigi apenas o texto da mensagem abaixo de "Ninja" para "Missão"
            throw new MissionNotFoundException("Missão não encontrada com o ID: " + id);
        }
    }
}
