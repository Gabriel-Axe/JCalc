# JCalc
Um parser codificado em java focado em cálculo e operações matemáticas

## Table of Contents
- [Sobre](#sobre)
- [Features](#features)
- [Instalação](#instalação)
- [Testes](#testes)
- [Tech Stack](#tech-stack)

## Sobre
Este projeto foi desenvolvido para estudar TDD (Test Driven Development) e boas práticas de testes no ecosistema java

## Features
- Parsing de expressões matemática
- Facilmente expansível com a inserção de enums

## Instalação
Step-by-step instructions:

```bash
git clone https://github.com/Gabriel-Axe/JCalc.git
cd JCalc
./gradlew run
````

## Limitações do projeto

* Atualmente, o código não valida o input, podendo levar a erros em caso do usuário inserir letras ou símbolos
* O loop principal do projeto não permite uma saída elegante
* Atualmente os testes combrem operações individuais e não o código totalmente
* Código deve ser atualizado em caso de atualização dos operadores

## Testes

Os testes foram escritos antes da implementação, seguindo a metodologia TDD.

Para efetuar os testes, digite na raiz do projeto (JCalc):
```bash
./gradlew test
```
### Testes realizados
- Set de operandos correto
- Resultados são trazidos corretamente do parser
- Seleção de operador é feita de forma correta
- Testes de operações matemáticas

## Tech Stack

* Java 21
* JUnit
* Gradle

