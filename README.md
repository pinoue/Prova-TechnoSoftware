# Prova-TechnoSoftware
### Build
É necessario a criação de um banco de dados Postgres com nome de Prova.
### API
Para carregar o banco de dados é necessario realizar um 
@Get CarregarBanco localhost:8080/api/v1/cidade/CarregarBanco

#### Demais APIS
Listar Todas as Cidades
@Get localhost:8080/api/v1/cidade

Pesquisa Por Id
@Get localhost:8080/api/v1/cidade/ById/{id}
Parametros: trocar {id} pelo Codigo do IBGE da cidade

Pesquisa Por Nome
@Get localhost:8080/api/v1/cidade/ByName/{name}
Parametros: trocar {name} pelo Nome da cidade

