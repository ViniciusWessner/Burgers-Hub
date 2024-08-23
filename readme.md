# BurgerHub

## Arquitetura do projeto

![FluxodoProjeto](https://github.com/ViniciusWessner/Burgers-Hub/blob/dev/assets/FlameShot_23_08_11_28.png)

Este projeto consiste em uma aplicação que consome uma API de hambúrgueres. A arquitetura é modularizada em diferentes camadas para facilitar a manutenção, escalabilidade e teste. Aqui está a descrição de cada camada e suas responsabilidades.


### 1. **Data**
A camada de dados lida com a obtenção e processamento de informações da API externa.

### 2. **Domain**
A camada de domínio contém a lógica de negócios e é independente de qualquer tecnologia externa.

### 3. **DI (Dependency Injection)**
Esta camada contém os módulos responsáveis pela injeção de dependências em outras partes do código, facilitando a modularização e teste das classes.

### 4. **Presenter (Camada de Apresentação)**
Esta camada cuida da lógica e apresentação da interface do usuário.

### 5. **Util**
Contém classes auxiliares que ajudam a manter o código limpo e organizado.

## Tecnologias Utilizadas
- **Kotlin**
- **Retrofit** para requisições de rede
- **Coroutines** para operações assíncronas
- **Dependency Injection** para gestão de dependências
- - **Mock Interceptor** para fazer requisições em dados mockados
- **MVVM** para arquitetura de apresentação
