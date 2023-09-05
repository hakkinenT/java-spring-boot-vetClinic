# Clínica Veterinária

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/hakkinenT/java-spring-boot-vetClinic/blob/main/LICENSE) 
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

## Sobre o projeto
Projeto Clínica Veterinária é um projeto desenvolvido com o objetivo de por em prática os conhecimento adquiridos durante o Curso **Java Spring Professional**, ministrado pelo Professor Nelio Alves da DevSuperior.

O projeto consiste na implementação de uma API REST para gerenciar os atendimentos realizados em uma Clínica Veterinária.

## Modelo Conceitual
> OBS: Esse diagrama, assim como a ideia do projeto, é baseado no projeto apresentado no livro **UML 2 - Uma Abordagem Prática** do autor Gilleanes T. A. Guedes.


![Modelo Conceitual](https://github.com/hakkinenT/assets/blob/master/java-spring-projects/vetClinic/diagrama-clinica-vet.png)


## Funcionalidades

- Gerenciar Animais
- Gerenciar Clientes
- Gerenciar Espécies
- Gerenciar Veterinários
- Marcar Consultas
- Atender Consultas
- Marcar Exames

## Tecnologias Utilizadas

- Java
- Spring boot
- JPA / Hibernate
- PostgreSQL
- H2

## Aprendizados

Neste projeto foi possível aprender sobre como criar **annotations** customizadas pra usar com o Bean Validation para validar os dados de entrada da API. 


## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/hakkinenT/java-spring-boot-vetClinic.git
```

Entre no diretório do projeto

```bash
  cd java-spring-boot-vetClinic
```

Rode a aplicação

```bash
  ./mvnw spring-boot:run
```


## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```


## Autores

- [@hakkinenT](https://github.com/hakkinenT)
