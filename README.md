# NexaFood API 🍔

API RESTful para uma plataforma de delivery de comida, similar ao iFood. Este projeto foi desenvolvido como parte de um estudo aprofundado em desenvolvimento de sistemas, focando em boas práticas de arquitetura e tecnologias modernas do ecossistema Java.

## ✨ Sobre o Projeto

O NexaFood é um sistema backend robusto que serve como a espinha dorsal para um aplicativo de delivery. Ele gerencia restaurantes, seus cardápios e, futuramente, os pedidos dos clientes. O foco desta primeira versão foi construir uma base sólida e escalável, utilizando uma arquitetura de camadas bem definida e DTOs para garantir um contrato de API seguro e flexível.

---

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* **[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**
* **[Spring Boot 3](https://spring.io/projects/spring-boot)**
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
* **[Maven](https://maven.apache.org/)**
* **[PostgreSQL](https://www.postgresql.org/)**
* **[Docker](https://www.docker.com/)**
* **[Lombok](https://projectlombok.org/)**

---

## ⚙️ Como Executar o Projeto

Para executar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

* [JDK 17](https://adoptium.net/temurin/releases/?version=17) ou superior
* [Docker](https://www.docker.com/products/docker-desktop/)
* [Maven](https://maven.apache.org/download.cgi) (opcional, pois o projeto usa o Maven Wrapper)
* Uma IDE como [VS Code](https://code.visualstudio.com/) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Postman](https://www.postman.com/) para testar os endpoints

### Passos para Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/gustavogalazzo/nexafood.git](https://github.com/gustavogalazzo/nexafood.git)
    cd nexafood
    ```

2.  **Inicie o banco de dados com Docker:**
    * Certifique-se de que o Docker Desktop está em execução.
    * Na raiz do projeto, execute o comando:
    ```bash
    docker-compose up -d
    ```

3.  **Execute a aplicação:**
    * Você pode rodar a aplicação diretamente pela sua IDE, executando a classe principal `NexaFoodApplication.java`.
    * Ou, se preferir, via terminal Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **A API estará disponível em `http://localhost:8080`**.

---

##  endpoints da API

A API possui um CRUD completo para a entidade `Restaurante`.

| Verbo  | Endpoint                                | Descrição                                  |
|--------|-----------------------------------------|--------------------------------------------|
| `POST` | `/api/restaurantes`                     | Cria um novo restaurante.                    |
| `GET`  | `/api/restaurantes`                     | Lista todos os restaurantes cadastrados.   |
| `GET`  | `/api/restaurantes/{id}`                | Busca um restaurante específico pelo seu ID. |
| `PUT`  | `/api/restaurantes/{id}`                | Atualiza os dados de um restaurante.       |
| `DELETE`| `/api/restaurantes/{id}`                | Deleta um restaurante.                     |
| `POST` | `/api/restaurantes/{restauranteId}/produtos` | Cria um novo produto para um restaurante. |

Você pode encontrar uma coleção do Postman para testar os endpoints no futuro (se você criar uma).

---

## 👨‍💻 Autor

Desenvolvido por **Gustavo Galazzo**.

* [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gustavo-galazzo-348068157/)
* [![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/gustavogalazzo)