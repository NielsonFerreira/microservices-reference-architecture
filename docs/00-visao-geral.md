# Visão Geral da Arquitetura de Referência

Este projeto define uma **Arquitetura de Referência para Microsserviços Java Spring na AWS**, servindo como base reutilizável e padronizada para construção de sistemas distribuídos, escaláveis e seguros.

## Objetivos
- Padronizar práticas de desenvolvimento backend com **Spring Boot** e **Spring Cloud**.
- Facilitar a **observabilidade** (logs, métricas, tracing).
- Garantir **segurança e conformidade** com boas práticas AWS.
- Habilitar **escalabilidade horizontal** e **resiliência** com arquitetura baseada em eventos.
- Servir como **template** para novos times/projetos.

## Macro Arquitetura
- **Frontend** → acessa via `API Gateway`
- **Gateway Service** → autenticação, autorização (JWT + OAuth2) e roteamento para microsserviços
- **User Service** → cadastro de usuários
- **Product Service** → cadastro de produtos
- **Banco de Dados** → RDS (Postgres / H2)
- **Mensageria** → Kafka (MSK)
- **Observabilidade** → CloudWatch