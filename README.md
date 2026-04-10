# 📌 Spring Boot CRUD API

Este projeto é uma API REST desenvolvida com **Spring Boot** para gerenciamento de **Departamentos** e **Vendedores (Sellers)**, implementando operações completas de CRUD e relacionamento entre entidades.

---

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de dados H2
* Maven

---

## 📂 Estrutura do projeto

O projeto segue uma arquitetura em camadas:

* **Controller** → Responsável pelas requisições HTTP
* **Service** → Contém as regras de negócio
* **Repository** → Acesso ao banco de dados (JPA)
* **Entities** → Representação das tabelas

---

## 🧩 Modelo de domínio

### Department

* `id`
* `name`

### Seller

* `id`
* `name`
* `email`
* `birthDate`
* `baseSalary`
* `department` (ManyToOne)

---

## 🔗 Relacionamento

* Um **Department** pode ter vários **Sellers**
* Um **Seller** pertence a um único **Department**

---

## ⚙️ Funcionalidades

### Department

* ✔️ Buscar todos
* ✔️ Buscar por ID
* ✔️ Inserir
* ✔️ Atualizar
* ✔️ Deletar

### Seller

* ✔️ Buscar todos
* ✔️ Buscar por ID
* ✔️ Inserir
* ✔️ Atualizar
* ✔️ Deletar

---

## 🧪 Como testar a API

Você pode testar utilizando o **Postman** ou qualquer cliente HTTP.

### 🔍 Buscar todos os departamentos

```
GET /departments
```

### 🔍 Buscar departamento por ID

```
GET /departments/{id}
```

### ➕ Criar departamento

```
POST /departments
```

```json
{
  "name": "Games"
}
```

---

### 🔍 Buscar todos os sellers

```
GET /sellers
```

### 🔍 Buscar seller por ID

```
GET /sellers/{id}
```

### ➕ Criar seller

```
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

### 🔄 Atualizar seller

```
PUT /sellers/{id}
```

### ❌ Deletar seller

```
DELETE /sellers/{id}
```

---

## 🗄️ Banco de dados

O projeto utiliza o banco H2 em memória:

```
jdbc:h2:mem:demo_spring
```

Os dados iniciais são carregados automaticamente via arquivo `import.sql`.

⚠️ Observação: os dados são resetados sempre que a aplicação é reiniciada.

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de:

* Consolidar conhecimentos em Spring Boot
* Aplicar conceitos de API REST
* Trabalhar com JPA e ORM
* Evoluir de JDBC puro para uma abordagem com framework

---

## 📌 Próximos passos (melhorias futuras)

* Implementar tratamento de exceções (HTTP 404, 400, etc.)
* Utilizar `ResponseEntity` nas respostas
* Adicionar DTOs para melhor organização
* Migrar para banco de dados persistente (MySQL/PostgreSQL)

---

## 👨‍💻 Autor

Desenvolvido por **Bruno** 🚀
