# SQUAD GAMASTER 


[//]: # (![Image]&#40;http://s2.glbimg.com/ISAMH15-7x5uueooUfpwrNr_S5I=/s.glbimg.com/jo/g1/f/original/2011/08/22/22-java-300.jpg "Imagem JAVA"&#41;)
![Image](./Arquivos/squad-logo-1.png "Imagem JAVA")
***
## Sobre o projeto
Trata-se da elaboração de uma aplicação que faça gerenciamento de conta bancária, permitindo que
sejam feitas as operações de criação, consulta e remoção, além das operações de
saque e depósito e essa conta também deverá ter um cartão de crédito.
***
## Construção do Projeto   
Para o desenvolvimento da aplicação foram utilizadas as seguintes tecnologias:

- [x] Java 11
- [x] Spring Boot
- [x] MySQL
- [x] Swagger
***
### Diagrama de Classes
![Image](./Arquivos/Diagrama%20de%20Classe.PNG)

  >- **Conta:** classe abstrata que define o modelo de entidade Conta e seus atributos  e métodos (depositar, sacar, transfere) e a implementação dos atributos que definem uma Conta bancária (numeroAgencia, numeroConta, banco, saldo, cliente).
  
  >- **Conta Corrente:** classe concreta que extende a classe Conta.

  >- **Cliente:** implementação da classe Cliente com os atributos que definem um cliente do banco

  >- **Cliente:** implementação da classe Cliente com os atributos que definem um cliente do banco

  >- **Movimentação:**  Classe que representa uma entidade de banco de dados que irá servir para os registros de transacoes entre contas e conta do cliente.

### Outras informações do projeto:
  - **Quadro Kanban utilizado pela equipe de Desenvolvimento:** https://trello.com/b/mFKDdjOR/our-bank

## Membros
  - [Isaque Silva](https://github.com/silvaij)
  - [Wesley Fernandes](https://github.com/WesleyOliver)
  - [Thiago Gomes](https://github.com/thiagosquid)
  - [Eliton Oliveira](https://github.com/alejandro-espejo)
  - [Benivaldo Junior](https://github.com/benorio)
  - [Alejandro Yujra Espejo](https://github.com/alejandro-espejo)
