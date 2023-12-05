[![CI Class](https://github.com/LiviaJacklinne/INATEL-C214-Trabalho-Final/actions/workflows/maven.yml/badge.svg)](https://github.com/LiviaJacklinne/INATEL-C214-Trabalho-Final/actions/workflows/maven.yml)


# Trabalho Final C214 LAB

## Apresentação do projeto
Foi criada uma API para gerenciar tarefas (CRUD), onde o usuário pode salvar seus compromissos.

## Tecnologias
* Spring Boot
* Spring MVC
* Spring Data JPA
* H2 (MySql)
> #### Praticas
>* API REST
>* Testes
>* DRY (Don't Repeat Yourself - Sem repetição de código)
>* Injeção de dependencia


## Preparação de Ambiente

Você pode usar uma IDE de sua escolha, como recomendação indico o [Intellij (2023.1.5)](https://www.jetbrains.com/pt-br/idea/download/other.html).

Baixe o executável do [Java (JDK)](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows).

Para o nosso projeto em especifico, você vai precisar do [POSTMAN](https://www.postman.com/downloads/)

## Como Executar

* Clone o repositorio do git `git clone https://github.com/LiviaJacklinne/INATEL-C214-Trabalho-Final.git`
* Carregue a build 

> A API poderá ser acessada em [localhost:8080](http://localhost:8080)

## API Endpoints
 * #### Criar tarefa 
``` 
POST: http://localhost:8080/api/todo/create

 {
    "nome" : "Tarefa 1",
    "descricao" : "AA",
    "realizado" : "false"
 }
```

* #### Listar tarefa
```
GET: http://localhost:8080/api/todo/list
```

* #### Alterar tarefa
``` 
PUT: http://localhost:8080/api/todo/update

 {
    "nome" : "Tarefa 1",
    "descricao" : "AA",
    "realizado" : "true"
 }
``` 

* #### Deletar tarefa
    #####  OBS: Troque o `ID` da url pelo id que deseja apagar
``` 
DELETE: http://localhost:8080/api/todo/delete/ID
```
