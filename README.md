# API TODO-LIST-API
API de sistema de armazenamento/leitura de tarefas em Java e Spring Boot.

### Detalhes da API RESTful
A API RESTful de armazenamento/leitura de tarefas contém as seguintes características:  
* Projeto criado com Spring Boot e Java 8
* Banco de dados Oracle com JPA e Spring Data JPA

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git e o banco de dado Oracle.

Segue link para download e tutorial de instalação do banco Oracle: https://www.oracle.com/br/database/technologies/appdev/xe.html
```
git clone https://github.com/juliteiro/todo-list-api.git
cd todo-list-api
mvn spring-boot:run
```
### Importando o projeto no Eclipse ou STS
No terminal, execute a seguinte operação:
```
mvn eclipse:eclipse
```
No Eclipse/STS, importe o projeto como projeto Maven.

### Configurações básicas para conexão com o banco
No arquivo application.properties na pasta src/main/resources configurar conexão para acesso ao banco de dados. 

spring.datasource.url=jdbc:oracle:thin:connection  -> substituir "connection" com a sua string de conexão.  
spring.datasource.username=DB_user  -> substituir "DB_user" com seu usuário do banco.
spring.datasource.password=DB_password  ->substituir "DB_password" com sua senha do seu usuário.

### Endpoints

Método GET:

Para listar todas as tarefas utilize a url http://localhost:8080/tarefa/  
Para buscar uma tarefa pelo seu id utilize a url http://localhost:8080/tarefa/{id} -> substituir "{id}" pelo id desejado.  
Para informações de performance das requisições realizadas acesse a url http://localhost:8080/log/ 

Método POST:

Para salvar uma nova tarefa utilize a url http://localhost:8080/tarefa/

Método PUT:

Para alterar uma tarefa utilize a url http://localhost:8080/tarefa/{id} -> substituir "{id}" pelo id desejado. 

Método DELETE:

Para deletar uma tarefa utilize a url http://localhost:8080/tarefa/{id} -> substituir "{id}" pelo id desejado. 

Obs: Nos cenários de testes do projeto feitos no Postman tem um exemplo de chamada para cada método http mencionado. 


### Postman
No diretório src/main/resources/postman, do projeto, contém o arquivo TODO-LIST-API.postman_collection com alguns testes para execução. 

## License
[MIT](https://choosealicense.com/licenses/mit/)
