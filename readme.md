# demoCRUD
Aplicação demonstração de CRUD utilizando Spring com banco de dados MySQL.


## Requisitos:
- Para execução da aplicação é necessário estar com um MySQL server rodando um banco de dados chamado "registro";
- Executar o binário disponibilisado v1.0.
Ou a partir do projeto executar (RUN) classe "RegistroApplication";
- Efetuar as consultas ao banco de dados no endereço:
http://localhost:8080/contatos/

## Para efetuar as requisições no postman:
### request com GET
- busca todos os contatos: sendGET http://localhost:8080/contatos
- busca contato por id: sendGET http://localhost:8080/contatos/1
### request com POST
- Cadastra novo contato: sendPOST http://localhost:8080/contatos/
Utilizar JSON:
{"nome":"bob","email":"bob@teste.com","celular":"11 999999999"}
### request com PUT
- Atualiza contato por id: sendPUT http://localhost:8080/contatos/1/
Utilizar JSON:
{"nome":"bob","email":"bob@teste.com","celular":"11 999999999"}
### request com DELETE
- deleta contato por id: sendDELETE http://localhost:8080/contatos/1/1


## Outras opções para execução das requisições:
No projeto existe uma classe que utiliza todos os métodos descritos acima, as requisições são feitas por meio de HTTP. 
Para executar esta classe rodar  a classe "ContatoControllerTeste" contida em "registro\src\test\java\br\com\afs\registro".
