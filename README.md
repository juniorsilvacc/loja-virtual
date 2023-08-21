# API - Loja-Virtual
Backend App Loja Virtual - É uma API de uma plataforma e-commerce

Desenvolvido com as seguintes tecnologias:
- Conceitos de boas práticas e qualidade no código, usando Design Patterns, Clean Architecture, Domain Driven Design (DDD) e Princípios SOLID
- Backend **API REST** com o framework **Spring Boot** 3.0.3 e **Java** 19
- Autenticação e autorização de usuários com **JWT** (JSON Web Token)
- Banco de dados relacional **PostgreSQL**
- **Flyway** migrações de banco de dados
- Apache **Maven** gerenciamentos de depêndencias
- **Swagger** para documentação do projeto
- **Docker**

---
## Como executar o projeto
Edite o arquivo `application.properties` em `loja-virtual/src/main/resources` com as informações necessárias correspondentes às configurações da sua máquina (usuário/senha do banco de dados e também do provedor de email para envio automático do sistema).
O projeto foi construído com a IDE Eclipse. Para executá-lo:

1. Baixe e instale o Docker Desktop
2. Faça o Download do zip do projeto ou clone o repositório Git e extraia o conteúdo do arquivado compactado
3. Navegue até a pasta do projeto e abra o Prompt de Comando do Windows ou Terminal do GNU/Linux
4. Execuete o comando `mvn clean package -DskipTests`. Ele irá gerar os target jar
5. Execute o comando `docker-compose up -d --build`. Ele irá criar um container chamado lojavirtual e db-lojavirtual-postgres contendo a imagem do banco de dados PostgreSQL e Jdk19.
6.  Abra o Eclipse ou IDE de sua preferência.
7.  Importe o projeto baixado: Vá em File > Open Projects from File System. Selecione a pasta pela opção "Directory" e pressione Finish.
8.  Espere o Maven baixar todas as dependências.
9.  Abra a classe java "loja-virtual" e execute o método main.
10.  O projeto irá ser executado.
11.  Para testar os recursos das URLs acima, use alguma ferramenta de testes de API, como o **Postman**; 

### Autor
Feito por Cícero Júnior. 👋🏽 Entre em contato! <br>
<a href="https://www.linkedin.com/in/juniiorsilvadev/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
