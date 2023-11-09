**README.md**

# JeoftonBank API

## Visão Geral

O JeoftonBank é uma API bancária simples desenvolvida para um projeto da turma de ADS da UNIPÊ. Ele fornece funcionalidades básicas para gerenciamento de usuários, transações financeiras e informações de conta.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.5
- PostgreSQL
- Maven

## Como Começar

1. Clone o repositório:

```bash
git clone https://github.com/ramonmqs/JeoftonBank.git
cd JeoftonBank
```

2. Compile o projeto usando o Maven:

```bash
mvn clean install
```

3. Execute a aplicação:

```bash
java -jar target/JeoftonBank-0.0.1-SNAPSHOT.jar
```

A API estará acessível em `https://jeofton-bank.onrender.com/api`.

## Endpoints

### 1. Criar Usuário

- **Endpoint**: `POST /api/usuarios`
- **Corpo da Requisição**:
  ```json
  {
    "nome": "Nome do Usuário",
    "saldo": 100.0,
    "ativo": true
  }
  ```
- **Resposta**: Retorna o usuário criado.

### 2. Listar Usuários

- **Endpoint**: `GET /api/usuarios`
- **Resposta**: Retorna uma lista de usuários ativos.

### 3. Inativar Usuário

- **Endpoint**: `PUT /api/usuarios/{id}/inativar`
- **Variável de Caminho**: `id` - ID do usuário
- **Resposta**: Retorna o usuário inativado.

### 4. Atualizar Status do Usuário

- **Endpoint**: `PUT /api/usuarios/{id}/status`
- **Variável de Caminho**: `id` - ID do usuário
- **Corpo da Requisição**:
  ```json
  {
    "ativo": false
  }
  ```
- **Resposta**: Retorna o usuário atualizado.

### 5. Verificar Saldo

- **Endpoint**: `GET /api/saldo`
- **Parâmetro da Requisição**: `usuarioId` - ID do usuário
- **Resposta**: Retorna o saldo atual do usuário.

### 6. Realizar Compra

- **Endpoint**: `POST /api/compra`
- **Corpo da Requisição**:
  ```json
  {
    "valor": 50.0,
    "usuarioId": 1
  }
  ```
- **Resposta**: Retorna uma mensagem indicando se a compra foi aprovada ou negada.

### 7. Realizar Depósito

- **Endpoint**: `POST /api/depositar`
- **Parâmetros da Requisição**:
  - `usuarioId` - ID do usuário
  - `valor` - Valor do depósito
- **Resposta**: Retorna uma mensagem indicando o sucesso do depósito.

## Configuração do Banco de Dados

A aplicação está configurada para utilizar o PostgreSQL como banco de dados. Certifique-se de que o servidor PostgreSQL está em execução e atualize o arquivo `application.properties` com as configurações do seu banco de dados.

```properties
spring.datasource.url=jdbc:postgresql://seu-servidor-postgresql/jeofton_bank
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

## Notas Adicionais

- A aplicação utiliza o Spring Boot DevTools para recarregamento automático durante o desenvolvimento.
- Certifique-se de ter o Java 17 instalado.

Sinta-se à vontade para explorar e personalizar o código conforme suas necessidades específicas!

---

**Observação**: Substitua espaços reservados como `seu-servidor-postgresql`, `seu-usuario` e `sua-senha` com seus detalhes reais do banco de dados.
