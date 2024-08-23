# Burger App

Este projeto consiste em uma aplicação que consome uma API de hambúrgueres. A arquitetura é modularizada em diferentes camadas para facilitar a manutenção, escalabilidade e teste. Aqui está a descrição de cada camada e suas responsabilidades.

## Camadas do Projeto

### 1. **Data**
A camada de dados lida com a obtenção e processamento de informações da API externa.

- **api**:
    - **ServiceAPI**: Responsável por fazer as chamadas de rede, como requisições para obter dados de uma API externa.

- **mapper**:
    - **BurgerMapper**: Converte os dados recebidos de uma fonte externa (geralmente em JSON) para modelos utilizáveis dentro da aplicação.

- **model**:
    - **BurgerResponse**, **ErrorResponse**, etc.: Representam as respostas do servidor e os dados que chegam da API.

- **repository**:
    - **BurgerRepositoryImpl**: Implementação do repositório que lida com a lógica de obtenção de dados, seja da rede ou de um banco de dados local.

### 2. **Domain**
A camada de domínio contém a lógica de negócios e é independente de qualquer tecnologia externa.

- **model**:
    - **Burger**, **Image**, **Ingredient**: Modelos que representam as entidades de negócio. Estes modelos são independentes da infraestrutura ou frameworks externos.

- **repository**:
    - **BurgerRepository**: Define as operações disponíveis para o repositório, como buscar hambúrgueres por nome ou ID.

- **usecase**:
    - **GetBurgerByNameUseCase**, **GetBurgersUseCase**: Casos de uso responsáveis pela lógica de negócios, executando ações como buscar uma lista de hambúrgueres ou um hambúrguer específico.

### 3. **DI (Dependency Injection)**
Esta camada contém os módulos responsáveis pela injeção de dependências em outras partes do código, facilitando a modularização e teste das classes.

### 4. **Presenter (Camada de Apresentação)**
Esta camada cuida da lógica e apresentação da interface do usuário.

- **burgers**:
    - **BurgersAdapter**, **BurgersFragment**, **BurgerViewModel**: Responsáveis pela apresentação e manipulação da interface do usuário, sincronizando os dados entre a View (UI) e o resto da aplicação.

- **details**:
    - **DetailsFragment**, **DetailsViewModel**, **IngredientsAdapter**: Responsáveis pela exibição dos detalhes de um hambúrguer específico.

- **MainActivity**: O ponto de entrada da aplicação Android.

### 5. **Util**
Contém classes auxiliares que ajudam a manter o código limpo e organizado.

- **Extensions.kt**: Extensões úteis para facilitar o desenvolvimento.
- **StateView**: Classe que facilita a comunicação de estados (como carregando, erro, sucesso) na interface do usuário.

## Tecnologias Utilizadas
- **Kotlin**
- **Retrofit** para requisições de rede
- **Coroutines** para operações assíncronas
- **Dependency Injection** para gestão de dependências
- **MVVM** para arquitetura de apresentação

## Instalação e Uso
1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/burger-app.git