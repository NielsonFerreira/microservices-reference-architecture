# 🏗 Microservices Reference Architecture

Este repositório contém um projeto de referência para a construção de sistemas baseados em microsserviços utilizando **Java 21**, **Spring Boot** e **AWS**.  
O objetivo é fornecer uma base sólida, bem documentada e modular, que sirva de ponto de partida para novos projetos.

---

## 📌 Visão Geral

### 🎯 Objetivo
Fornecer uma arquitetura de referência escalável, segura e de fácil manutenção para aplicações baseadas em microsserviços.

### 📚 Escopo
- Implementar microsserviços independentes e desacoplados.
- Utilizar **Spring Boot** e padrões modernos de desenvolvimento.
- Integrar boas práticas de DevOps e CI/CD.
- Garantir observabilidade, monitoramento e documentação das APIs.

### 👥 Público-Alvo
- Desenvolvedores backend.
- Arquitetos de software.
- Equipes que buscam um template para iniciar projetos com microsserviços.

---

## 📂 Estrutura do Repositório
```
microservices-reference-architecture/
│
├── common/ # Módulo comum compartilhado entre microsserviços
│ ├── src/main/java/com/example/common/config/
│ ├── src/main/java/com/example/common/dto/
│ ├── src/main/java/com/example/common/exception/
│ └── src/main/java/com/example/common/utils/
│
├── user-service/ # Microsserviço de gerenciamento de usuários
│ ├── src/main/java/com/microservices/reference/user_service/
│ ├── src/test/java/com/microservices/reference/user_service/
│
├── .github/workflows/ # Configuração de CI/CD com GitHub Actions
├── README.md # Documentação principal
└── ...
```

---

## 🛠 Tecnologias e Frameworks

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Springdoc OpenAPI / Swagger**
- **JUnit 5** + **Mockito**
- **AWS (IAM, VPC, RDS, S3, Lambda, etc.)**
- **Gradle**
- **Docker** (para empacotamento e execução)
- **GitHub Actions** (CI/CD)
- **Spring Boot Actuator** (monitoramento)

---

## 🏛 Padrões de Arquitetura

- **Arquitetura em Camadas** ou **Hexagonal** (dependendo do microsserviço).
- Uso de **DTOs** para comunicação externa.
- **Configuração centralizada** para reuso de código no módulo `common`.
- **Documentação de API** com OpenAPI 3 (Swagger UI).
- **Testes automatizados** para garantir qualidade do código.

---

## 🚀 Como Rodar Localmente

### Pré-requisitos
- **Java 21**
- **Gradle** (ou usar o wrapper `./gradlew`)
- **Docker** (opcional, para rodar dependências externas)
- **Git**

### Passos
1. Clonar o repositório:
   ```bash
   git clone https://github.com/seu-usuario/microservices-reference-architecture.git
   cd microservices-reference-architecture
2. Compilar e rodar os testes:
   ```bash
   ./gradlew build

3. Executar um microsserviço (exemplo: `user-service`):
   ```bash
   ./gradlew :user-service:bootRun

4. Acessar a documentação da API:
   ```bash
   **http://localhost:8080/swagger-ui/index.html**

##📄 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
