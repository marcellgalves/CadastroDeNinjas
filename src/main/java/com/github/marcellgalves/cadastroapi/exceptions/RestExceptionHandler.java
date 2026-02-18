package com.github.marcellgalves.cadastroapi.exceptions;

import com.github.marcellgalves.cadastroapi.exceptions.MissionNotFoundException;
import com.github.marcellgalves.cadastroapi.exceptions.NinjaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j // Ativa os logs automáticos
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // Trata o erro de Ninja não encontrado
    @ExceptionHandler(NinjaNotFoundException.class)
    private ResponseEntity<String> ninjaNotFoundHandler(NinjaNotFoundException exception) {
        log.warn("Tentativa de acesso negada: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // Trata o erro de Missão não encontrada
    @ExceptionHandler(MissionNotFoundException.class)
    private ResponseEntity<String> missionNotFoundHandler(MissionNotFoundException exception) {
        log.warn("Tentativa de acesso negada: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // Trata erros genéricos que você não previu (para a API não expor detalhes técnicos)
    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> genericHandler(Exception exception) {
        log.error("Erro interno inesperado: ", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor.");
    }
}