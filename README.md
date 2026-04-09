Task Manager API
API REST para gerenciamento de tarefas, desenvolvida com Java e Spring Boot.
🚀 Tecnologias

Java 21
Spring Boot 3.5
Spring Data JPA + Hibernate
PostgreSQL 16
Docker + Docker Compose
Lombok
Maven

⚙️ Como rodar o projeto
Pré-requisitos: Java 21, Docker Desktop
# Clonar o repositório
git clone https://github.com/Israel875/task-manager-api

# Subir o banco de dados
docker-compose up -d

# Rodar a aplicação
./mvnw spring-boot:run

A API estará disponível em http://localhost:8080

Endpoints:
Método Rota Descrição
GET   /api/tasks          Listar todas as tarefas
GET   /api/tasks/{id}     Buscar tarefa por ID
POST  /api/tasks          Criar nova tarefa
PUT   /api/tasks/{id}     Atualizartarefa
DELETE /api/tasks/{id}    Deletar tarefa
GET    /api/tasks/status/{status}   Filtrar por status

📌 Status disponíveis

TODO — A fazer
IN_PROGRESS — Em andamento
DONE — Concluído

🔜 Melhorias futuras

Autenticação e autorização com JWT
Suporte a múltiplos usuários com tela de login
DTOs para separar entidade da API
Testes automatizados com JUnit e Mockito
Containerização completa com Docker
