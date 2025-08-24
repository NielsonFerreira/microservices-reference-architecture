# Arquitetura Técnica

## Microsserviços
- Implementados em **Java 21** + **Spring Boot 3.x**.
- Padrões:
    - **Arquitetura Hexagonal** (ports & adapters).
    - DTOs para transporte de dados.
    - Separação entre `application`, `domain`, `infrastructure`.
- Comunicação:
    - REST (síncrono) via Gateway.
    - Event-driven (assíncrono) via SNS/SQS.

## Infraestrutura AWS
- **API Gateway**: entrada única de requests.
- **ECS Fargate**: execução de containers.
- **RDS (Postgres / H2)**: persistência relacional.
- **S3**: armazenamento de documentos/arquivos.
- **CloudWatch**: monitoramento.
- **IAM**: controle de permissões.

## Observabilidade
- **Logs estruturados JSON**.
- **Tracing distribuído** com OpenTelemetry.
- **Dashboards** em CloudWatch.
