# Microsserviço de Vendas de Ingressos (Sales)

Este projeto faz parte de um sistema de Gerenciamento de Tickets e é responsável por registrar os eventos disponíveis e realizar a venda de ingressos para os usuários. Foi desenvolvido como atividade prática para a disciplina de Sistemas Web II (CSI607) da Universidade Federal de Ouro Preto (UFOP).

## Descrição da Atividade Prática 01

A proposta desta atividade prática é o desenvolvimento completo do microsserviço de Vendas (Sales). Ele implementa as operações de CRUD (Create, Read, Update, Delete) para as entidades **Event** (Evento) e **Sale** (Venda), seguindo uma arquitetura de 3 camadas (Controller, Service e Repository).

## Funcionalidades

* **Gerenciamento de Eventos:**
    * Cadastro, consulta, atualização e remoção de eventos.
    * Um evento possui tipo (palestra, show, etc.), descrição, data, período de vendas e preço.
* **Gerenciamento de Vendas:**
    * Registro de ingressos adquiridos por um usuário para um determinado evento.
    * Validação de regras de negócio para garantir que uma venda só pode ser criada para um evento existente.
    * Controle de status de pagamento (ex: Em aberto, Pago, Cancelado, etc.).

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.5.3**
* **Spring Data JPA:** Para persistência de dados.
* **H2 Database:** Banco de dados relacional em memória para ambiente de desenvolvimento.
* **Maven:** Gerenciador de dependências e build do projeto.
* **Lombok:** Para reduzir código boilerplate (getters, setters, etc.).

## Modelo de Dados

O microsserviço utiliza duas entidades principais: `Event` e `Sale`.

* **Event:** Armazena todas as informações sobre o evento.
* **Sale:** Registra uma venda, fazendo a ligação entre um `userId` e um `eventId`.


## Endpoints da API

A documentação completa de todos os endpoints disponíveis, com exemplos de requisição e resposta, pode ser encontrada no arquivo [**ENDPOINTS.md**](endpoints.md).

* **Porta Padrão:** `4000`

## Como Executar o Projeto

### 1. Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
* JDK 17 ou superior.
* Maven.
* Um cliente de API como Postman.

### 2. Execução

1.  Clone este repositório:
    ```bash
    git clone https://github.com/dudatimiraos/sales-microservice-web-II
    ```
2.  Navegue até a pasta raiz do projeto:
    ```bash
    cd nome-do-seu-repositorio
    ```
3.  Execute a aplicação usando o Maven Wrapper. Ele cuidará de baixar as dependências e iniciar o servidor.
    ```bash
    ./mvnw spring-boot:run
    ```
4.  A aplicação estará disponível em `http://localhost:4000`.
