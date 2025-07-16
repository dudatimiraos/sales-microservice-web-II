# Documentação da API - Microsserviço de Vendas de Ingressos

API responsável pelo gerenciamento de eventos e vendas de ingressos.

## Entidade: Events

Endpoints para gerenciar os eventos.

### 1. Criar um Novo Evento

Cria um novo registro de evento no sistema.

* **Método:** `POST`
* **URL:** `/events`
* **Corpo da Requisição (JSON):**
    ```json
    {
        "description": "Show da Banda XYZ",
        "type": 1,
        "date": "2025-12-01T22:00:00",
        "startSales": "2025-08-01T09:00:00",
        "endSales": "2025-11-30T23:59:59",
        "price": 120.00
    }
    ```
* **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": "c9a7b9e0-8c7a-4f6e-8d9a-9c7b6a5f4e3d",
        "description": "Show da Banda XYZ",
        "type": 1,
        "date": "2025-12-01T22:00:00",
        "startSales": "2025-08-01T09:00:00",
        "endSales": "2025-11-30T23:59:59",
        "price": 120.00,
        "createdAt": "2025-07-15T13:30:00.123456",
        "updatedAt": "2025-07-15T13:30:00.123456"
    }
    ```

### 2. Listar Todos os Eventos

Retorna uma lista com todos os eventos cadastrados.

* **Método:** `GET`
* **URL:** `/events`
* **Resposta de Sucesso (200 OK):**
    ```json
    [
        {
            "id": "c9a7b9e0-8c7a-4f6e-8d9a-9c7b6a5f4e3d",
            "description": "Show da Banda XYZ",
            "type": 1,
            "date": "2025-12-01T22:00:00",
            "startSales": "2025-08-01T09:00:00",
            "endSales": "2025-11-30T23:59:59",
            "price": 120.00,
            "createdAt": "2025-07-15T13:30:00.123456",
            "updatedAt": "2025-07-15T13:30:00.123456"
        }
    ]
    ```

### 3. Obter um Evento por ID

Busca um evento específico pelo seu UUID.

* **Método:** `GET`
* **URL:** `/events/{id}`
* **Resposta de Sucesso (200 OK):** O mesmo corpo da criação do evento.
* **Resposta de Erro (404 Not Found):** Retorna se o ID não for encontrado.

### 4. Atualizar um Evento

Atualiza os dados de um evento existente.

* **Método:** `PUT`
* **URL:** `/events/{id}`
* **Corpo da Requisição (JSON):**
    ```json
    {
        "description": "Show da Banda XYZ - Data Extra!",
        "price": 135.50
    }
    ```
* **Resposta de Sucesso (200 OK):** Retorna o objeto do evento com os dados atualizados.
* **Resposta de Erro (404 Not Found):** Retorna se o ID não for encontrado.

### 5. Deletar um Evento

Remove um evento do sistema.

* **Método:** `DELETE`
* **URL:** `/events/{id}`
* **Resposta de Sucesso (204 No Content):** Resposta sem corpo.
* **Resposta de Erro (404 Not Found):** Retorna se o ID não for encontrado.

---

## Entidade: Sales

Endpoints para gerenciar as vendas de ingressos.

### 1. Criar uma Nova Venda

Registra uma nova venda de ingresso para um usuário e um evento específico.

* **Método:** `POST`
* **URL:** `/sales`
* **Corpo da Requisição (JSON):**
    ```json
    {
        "userId": "a1b2c3d4-e5f6-7890-1234-567890abcdef",
        "event": {
            "id": "c9a7b9e0-8c7a-4f6e-8d9a-9c7b6a5f4e3d"
        },
        "saleStatus": 1
    }
    ```
* **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": "f1a2b3c4-d5e6-f7a8-b9c0-d1e2f3a4b5c6",
        "userId": "a1b2c3d4-e5f6-7890-1234-567890abcdef",
        "event": {
            "id": "c9a7b9e0-8c7a-4f6e-8d9a-9c7b6a5f4e3d",
            "description": "Show da Banda XYZ",
            ...
        },
        "saleDate": "2025-07-15T13:35:00.654321",
        "saleStatus": 1,
        "createdAt": "2025-07-15T13:35:00.654321",
        "updatedAt": "2025-07-15T13:35:00.654321"
    }
    ```
* **Resposta de Erro (400 Bad Request):**
    ```
    "Erro ao criar venda: Evento com ID c9a7b9e0-8c7a-4f6e-8d9a-9c7b6a5f4e3d não encontrado."
    ```

### 2. Listar Todas as Vendas

Retorna uma lista com todas as vendas.

* **Método:** `GET`
* **URL:** `/sales`

### 3. Obter uma Venda por ID

Busca uma venda específica pelo seu UUID.

* **Método:** `GET`
* **URL:** `/sales/{id}`
* **Resposta de Erro (404 Not Found):** Retorna se o ID não for encontrado.

### 4. Atualizar uma Venda

Atualiza os dados de uma venda (ex: alterar o status de pagamento).

* **Método:** `PUT`
* **URL:** `/sales/{id}`
* **Corpo da Requisição (JSON):**
    ```json
    {
        "saleStatus": 2 // 2 = Pago
    }
    ```
* **Resposta de Sucesso (200 OK):** Retorna o objeto da venda com os dados atualizados.

### 5. Deletar uma Venda

Remove uma venda do sistema.

* **Método:** `DELETE`
* **URL:** `/sales/{id}`
* **Resposta de Sucesso (204 No Content):** Resposta sem corpo.
* **Resposta de Erro (404 Not Found):** Retorna se o ID não for encontrado.