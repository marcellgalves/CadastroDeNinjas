# 🏯 Cadastro de Ninjas

Uma API REST desenvolvida em Spring Boot para gerenciar os ninjas e missões. Este projeto foca em boas práticas de backend, organização de serviços e um sistema robusto de logs.

---

## 🛠️ Tecnologias Utilizadas
* **Java 25** (ou a versão que você estiver usando)
* **Spring Boot 4**
* **Spring Data JPA** (Persistência de dados)
* **H2 Database** (Banco de dados em memória para testes rápidos)
* **Lombok** (Produtividade e código limpo)
* **SLF4J/Logback** (Sistema de logs profissional)

---

## 🚀 Funcionalidades Atuais
- [x] **Gerenciamento de Ninjas**: Cadastro, listagem, atualização e deleção.
- [x] **Sistema de Missões**: Vinculo de missões com diferentes ranks de dificuldade.
- [x] **Tratamento de Exceções Global**: Respostas HTTP limpas e padronizadas para o usuário.
- [x] **Logs de Operação**: Rastreabilidade completa no console para facilitar o debug.

---

## 🛡️ Tratamento de Erros e Logs
A API utiliza um `@ControllerAdvice` para capturar exceções customizadas, garantindo que o usuário receba uma mensagem clara em vez de um erro 500 genérico.

**Exemplos de Logs implementados:**
- `INFO`: Registra o início e o sucesso de operações como cadastros e deleções.
- `WARN`: Alerta sobre tentativas de acesso a IDs inexistentes.
- `ERROR`: Captura falhas críticas no sistema.

---
