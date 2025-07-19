# 📋 Pessoa API

Uma aplicação Java com Spring Boot para **cadastro e consulta de pessoas** por CPF. O projeto usa PostgreSQL como banco de dados, e inclui um front-end simples em HTML para interação com a API.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17
- ✅ Spring Boot 3
- ✅ Spring Data JPA
- ✅ PostgreSQL 16
- ✅ Maven
- ✅ HTML + JavaScript (front-end)
- ✅ Validações com Jakarta e Hibernate Validator

---

## 🗂️ Estrutura do Projeto

pessoas-api/
├── pom.xml
├── deploy.sh
├── schema.sql
├── README.md
├── src/
│ └── main/
│ ├── java/
│ │ └── com/pessoas-api/
│ │ ├── controller/
│ │ ├── dto/
│ │ ├── model/
│ │ ├── repository/
│ │ └── service/
│ └── resources/
│ ├── static/
│ │ └── index.html
│ └── application.properties

---

## 🧑‍💻 Funcionalidades

- Cadastro de pessoas com:
  - Nome
  - CPF (validação automática)
  - Data de nascimento
- Consulta de pessoa por CPF
- Validações via API
- Front-end HTML para testes

---

## 🐘 Configuração do PostgreSQL

1. Crie o banco:
sql
CREATE DATABASE seubanco;

2. Certifique-se que o PostgreSQL está configurado com:
- Usuário: postgres
- Senha: zeca
- Porta: 5132

3. O Spring executará automaticamente o schema.sql para criar a tabela pessoa.

---

# Inicialização do Projeto

1. Compilar e empacotar
mvn clean package

2. Executar a aplicação

java -jar target/pessoa-api-1.0.0.jar

Ou diretamente via Maven:
mvn spring-boot:run

3. Acessar
Front-end: http://localhost:8080/index.html
API REST: http://localhost:8080/api/pessoas
 
---

# Deploy com script
Se preferir automatizar:
chmod +x deploy.sh
./deploy.sh

---

# Exemplo de Requisições
POST /api/pessoas

{
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "dataNascimento": "2000-01-01"
}

GET /api/pessoas/cpf/123.456.789-00

---

# Requisitos para rodar
| Requisito  | Versão mínima |
| ---------- | ------------- |
| Java JDK   | 17            |
| Maven      | 3.8+          |
| PostgreSQL | 16            |

---

# Autoria
Projeto desenvolvido como estudo de integração entre Java + Spring Boot + PostgreSQL, com foco em boas práticas REST, validações e front-end leve. Por: José Cardozo e Filipe Lima