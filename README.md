# Vendas
## Descrição do Projeto
Esse é um desafio proposto pela serasa experian que consiste em um serviço do tipo API RESTful, para cadastro de vendedores e suas
regiões de atuação.

## Funcionalidades
Esta é uma aplicação Spring Boot com interface totalmente REST que permite:
*  inclusão de um vendedor
*  inclusão de uma área de atuação
*  Pesquisa de um vendedor por id.
*  Listar todos os vendedores com a área de atuação

## Tecnologias Utilizadas
* java 11
* Banco H2 em memória
* Spring boot, Spring MVC e Spring Data
* Junit e Mockito

## Como Rodar Localmente
Primeiro é preciso clonar o repositório usando o comando: 
```git clone git@github.com:isabeladutra/vendas.git```

É preciso ter instalado na máquina o java 11, segue o link da [página de download do java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

Em seguida, é só importar o projeto em uma IDE e mandar rodar, o projeto fica disponível em : http://localhost:8080/