# 📌 Spring Boot CRUD API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de **Departamentos** e **Vendedores (Sellers)**, implementando operações completas de CRUD, relacionamento entre entidades e boas práticas de desenvolvimento backend.

Este projeto começou como um CRUD simples e posteriormente foi refatorado para aplicar conceitos mais avançados estudados ao longo da jornada com Spring Boot.

---

# 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Bean Validation
* Banco de dados H2
* Maven

---

# 📂 Arquitetura do projeto

O projeto segue uma arquitetura em camadas:

* **Controller** → Responsável pelas requisições HTTP
* **Service** → Regras de negócio
* **Repository** → Acesso aos dados com JPA
* **DTOs** → Transferência e validação de dados
* **Entities** → Representação das tabelas do banco
* **Exception Handling** → Tratamento global de exceções

---

# 🧩 Modelo de domínio

## Department

* `id`
* `name`

## Seller

* `id`
* `name`
* `email`
* `birthDate`
* `baseSalary`
* `department`

---

# 🔗 Relacionamentos

* Um **Department** pode possuir vários **Sellers**
* Um **Seller** pertence a um único **Department**

Relacionamento implementado com:

* `@OneToMany`
* `@ManyToOne`

---

# ⚙️ Funcionalidades

## Department

* ✔️ Buscar todos
* ✔️ Buscar por ID
* ✔️ Inserir
* ✔️ Atualizar
* ✔️ Deletar

## Seller

* ✔️ Buscar todos
* ✔️ Buscar por ID
* ✔️ Inserir
* ✔️ Atualizar
* ✔️ Deletar

---

# ✅ Melhorias aplicadas na refatoração

Durante a refatoração do projeto foram implementadas melhorias importantes para aproximar a aplicação de um padrão mais profissional de API REST:

* DTOs para transferência de dados
* Uso de `ResponseEntity`
* Tratamento global de exceções com `@ControllerAdvice`
* Respostas customizadas para erros da API
* Validação de dados com Bean Validation
* Tratamento de erros de integridade do banco
* Relacionamentos JPA bidirecionais
* Padronização das respostas HTTP
* Melhor organização da arquitetura em camadas

---

# 🛡️ Validações implementadas

## Department

* Nome obrigatório
* Nome único no banco de dados

## Seller

* Nome obrigatório
* Email obrigatório
* Email válido
* Email único
* Data de nascimento não pode ser futura
* Salário não pode ser negativo

---

# 🧪 Exemplos de endpoints

## 🔍 Buscar todos os departamentos

```http
GET /departments
```

## ➕ Criar departamento

```http
POST /departments
```

```json
{
  "name": "Games"
}
```

---

## 🔍 Buscar todos os sellers

```http
GET /sellers
```

## ➕ Criar seller

```http
POST /sellers
```

```json
{
  "name": "Carlos Silva",
  "email": "carlos@gmail.com",
  "birthDate": "1995-06-15",
  "baseSalary": 3500.0,
  "department": {
    "id": 1
  }
}
```

---

# ⚠️ Tratamento de exceções

A API possui tratamento global de exceções para cenários como:

* Recurso não encontrado (`404`)
* Dados inválidos (`422`)
* Violação de integridade do banco (`400`)

---

# 🗄️ Banco de dados

O projeto utiliza banco H2 em memória:

```properties
jdbc:h2:mem:demo_spring
```

Os dados iniciais são carregados automaticamente via `import.sql`.

> ⚠️ Os dados são resetados sempre que a aplicação é reiniciada.

---

# 🎯 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de:

* Consolidar conhecimentos em Spring Boot
* Aplicar conceitos de API REST
* Trabalhar com JPA/Hibernate
* Evoluir de JDBC puro para uma arquitetura baseada em framework
* Praticar refatoração e boas práticas de backend

---

# 👨‍💻 Autor

Desenvolvido por **Joelson Bruno Costa Rodrigues** 🚀
