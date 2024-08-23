Explicação das camadas:
Data:

api: Aqui está o ServiceAPI, responsável por fazer as chamadas de rede, como requisições para obter dados de uma API externa.
mapper: O BurgerMapper converte dados recebidos de uma fonte externa (normalmente JSON) em modelos utilizáveis dentro da aplicação.
model: Aqui estão as respostas do servidor (BurgerResponse, ErrorResponse, etc.), que representam os dados que chegam da API.
repository: A implementação do repositório (BurgerRepositoryImpl) lida com a lógica de obtenção de dados, seja da rede ou de um banco de dados local.
Domain:

model: Modelos como Burger, Image, e Ingredient representam as entidades de negócio, que são independentes de qualquer framework ou tecnologia externa.
repository: A interface do repositório (BurgerRepository) define as operações disponíveis para o repositório, como buscar hambúrgueres por nome ou ID.
usecase: Os casos de uso (GetBurgerByNameUseCase, GetBurgersUseCase) são responsáveis pela lógica de negócios. Eles executam ações concretas na aplicação, como buscar uma lista de hambúrgueres ou um hambúrguer específico.
Di (Dependency Injection):

Essa pasta contém os módulos responsáveis por injetar dependências necessárias para outras partes do código, como módulos de rede, dados, e domínio. Isso facilita a modularização e teste das classes.
Presenter (ou camada de apresentação):

burgers: Contém o BurgersAdapter, BurgersFragment, e o BurgerViewModel. Essa camada é responsável pela apresentação e manipulação da interface do usuário. O ViewModel contém a lógica de interface e mantém os dados sincronizados entre a View (UI) e o restante da aplicação.
details: Contém fragmentos e ViewModels relacionados aos detalhes, como DetailsFragment, DetailsViewModel, e o IngredientsAdapter, que cuida da apresentação dos detalhes de um hambúrguer específico.
MainActivity: O ponto de entrada da aplicação Android.
Util:

Contém classes auxiliares como Extensions.kt, que provavelmente adicionam extensões úteis ao código, e StateView, uma classe que facilita a comunicação de estados (carregando, erro, sucesso, etc.).