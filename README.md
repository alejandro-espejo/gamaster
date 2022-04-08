# DESAFIO-WIPROO-GAMA 

### Modelagem e implementação do backend de um sistema bancário simples utilizando tecnologias como JPA, H2DB e MAVEN , Spring Boot 2.5.6

![Image](http://s2.glbimg.com/ISAMH15-7x5uueooUfpwrNr_S5I=/s.glbimg.com/jo/g1/f/original/2011/08/22/22-java-300.jpg "Imagem JAVA")

## Configuração

Antes de rodar a aplicação verifique se o arquivo application.properties está configurado corretamente com os atributos de conexão com banco de dados desejado ( url ( Driver | Provedor do Banco | Schema) , username , password , console enable , console path). Esse projeto utiliza um banco de dados H2Db pré-criado na inicialização do projeto em quanto o mesmo estiver em execução.

## Construção do Projeto

### Modelagem
  - **Conta:** classe concreta que define o modelo de entidade Conta e seus atributos  e métodos (depositar, sacar, transfere) e a implementação dos atributos que definem uma Conta bancária (numeroAgencia, numeroConta, banco, saldo, cliente).
  - **Cliente:** implementação da classe Cliente com os atributos que definem um cliente do banco (cpf , rg , nomeCompleto,email,telefone,endereco, conta )
  - **Operacao:** enum (CREDITO , DEBITO , PIX_ENVIADO , PIX_RECEBIDO) utilizado por classes da aplicação.
  - **Endereço:** Classe concreta que ira compor o cliente será também uma entidade de banco de dados.
  - **Extrato:**  Classe que representa uma entidade de banco de dados que irá servir para os registros de transacoes entre contas e conta do cliente.

### Repository
  - **ClienteRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Cliente.
  - **ContaRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Conta
  - **ExtratoRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Extrato

### Service
  - **ClienteService:** Serviços relativos ao ClienteRepository utilizados pela aplicação (delete(), findall(),findByCpf(String),  findByNomeCompleto(String), insert(ClienteDto), update(String,ClienteDto))
  - **ContaService:** Serviços relativos ao ContaRepository utilizados pela aplicação (depositar, findAllExtrato, sacar,transferir)

    

### Outras informações do projeto :
  - **Quadro Kanban utilizado pela equipe de Desenvolvimento:** https://trello.com/invite/b/CWedMemU/08957949f5fa9b52aa76b29fec34b20d/blue-bank-gama-academy
  - **Documentação da API:** Todos end-points do projeto foram mapeados com utilização do SWAGGER que podem ser visualizados no endereço : **http://localhost:8080/swagger-ui.html#/conta-controller ** segue na imagem a seguir:

## End-points :

![Image](https://github.com/silvaij/bluebank/blob/master/swagger_cliente-controller.PNG "Cliente")

![Image](https://github.com/silvaij/bluebank/blob/master/swagger_conta-controller.PNG "Conta")

![Image](https://github.com/silvaij/bluebank/blob/master/models.PNG "Models")




  ## Dependências Maven

  ```xml
 <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.6</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>br.com.bloodblue</groupId>
	<artifactId>bluebank</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>bluebank</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- SWAGEER -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>jakarta.validation</groupId>
			<artifactId>jakarta.validation-api</artifactId>
			<version>8.0</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
  ```

  ### Conexao com banco de dados (application-dev.properties)
  ```java
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.username=sa
  spring.datasource.password=
  spring.h2.console.enable=true
  spring.h2.console.path=/h2-console
  ```

## Testes
  Testes para validar o funcionamento corretos dos métodos nas classes de repository e service foram criados e podem ser encontrados em `src/test/java/br.com.bloodblue.bluebank`
    
## Membros
  - Isaque Silva.
  - Wesley Fernandes.
  - Thiago Gomes.
  - Eliton Oliveira
  - Viviane Viana Bresolin

    

  

