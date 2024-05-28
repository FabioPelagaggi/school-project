### Documentação de Execução do School Project, Spring Boot

Este projeto Spring Boot demonstra persistência de dados usando JPA, gerenciamento de configurações, e implementação de serviços baseados em diferentes tecnologias de armazenamento (H2, Redis, MongoDB) e ferramentas de monitoramento (Spring Boot Actuator).

### Requisitos

- **JDK 11+**
- **Maven 3.6+**
- **Docker** (para Redis e MongoDB)

### Passos para Executar o Projeto

#### 1. Clonar o Repositório

Clone o repositório do projeto para sua máquina local:
```sh
git clone https://github.com/FabioPelagaggi/school-project.git
cd seu-projeto
```

#### 2. Configurar o Docker (Redis e MongoDB)

Se você estiver usando Docker, suba os contêineres do Redis e MongoDB:

```sh
docker run -d -p 6379:6379 --name redis redis
docker run -d -p 27017:27017 --name mongodb mongo
```

#### 3. Configurar o Banco de Dados H2

O projeto já está configurado para usar o banco de dados H2 em memória. As configurações estão em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

#### 4. Construir o Projeto

Use o Maven para construir o projeto:

```sh
mvn clean install
```

#### 5. Executar a Aplicação

Execute a aplicação usando o Maven:

```sh
mvn spring-boot:run
```

Ou, se preferir, execute o JAR gerado:

```sh
java -jar target/seu-projeto-0.0.1-SNAPSHOT.jar
```

#### 6. Acessar a Consola H2

Acesse a consola H2 para verificar os dados no banco de dados H2:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: `password`

#### 7. Testar os Endpoints REST

Você pode usar ferramentas como **Postman** ou **curl** para testar os endpoints REST.

##### Endpoints Disponíveis

- **Aluno**
  - **GET** `/api/alunos` - Listar todos os alunos
  - **GET** `/api/alunos/{id}` - Obter aluno por ID
  - **POST** `/api/alunos` - Criar um novo aluno
  - **PUT** `/api/alunos/{id}` - Atualizar um aluno existente
  - **DELETE** `/api/alunos/{id}` - Deletar um aluno

- **Curso**
  - **GET** `/api/cursos` - Listar todos os cursos
  - **GET** `/api/cursos/{id}` - Obter curso por ID
  - **POST** `/api/cursos` - Criar um novo curso
  - **PUT** `/api/cursos/{id}` - Atualizar um curso existente
  - **DELETE** `/api/cursos/{id}` - Deletar um curso

- **Material Didático**
  - **GET** `/api/materiais` - Listar todos os materiais didáticos
  - **GET** `/api/materiais/{id}` - Obter material didático por ID
  - **POST** `/api/materiais` - Criar um novo material didático
  - **PUT** `/api/materiais/{id}` - Atualizar um material didático existente
  - **DELETE** `/api/materiais/{id}` - Deletar um material didático

#### 8. Monitoramento com Spring Boot Actuator

Acesse os endpoints do Actuator para monitorar a aplicação:

- **Health Check:** `http://localhost:8080/actuator/health`
- **Informações da Aplicação:** `http://localhost:8080/actuator/info`
- **Métricas:** `http://localhost:8080/actuator/metrics`

### Conclusão

Esta documentação fornece os passos necessários para configurar e executar o projeto Spring Boot. Com as configurações corretas e os serviços em execução, você pode testar as funcionalidades da aplicação usando os endpoints REST fornecidos. Se precisar de mais alguma ajuda ou informação, consulte a documentação oficial do Spring Boot ou as ferramentas específicas usadas (Docker, Redis, MongoDB).