package br.edu.gama.gamaster;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.gama.gamaster.model.CartaoCredito;
import br.edu.gama.gamaster.model.Cliente;
import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.ContaCorrente;
import br.edu.gama.gamaster.model.ContaEspecial;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.service.GerenciaContas;

@SpringBootApplication
public class GamasterApplication {
	public static List<Conta> contaList = new ArrayList<>();
	public static final String AGENCIA = "1500";

	public static void main(String[] args) {
		// Comentado para o Spring não tentar fazer a conexão com o banco por enquanto
//		SpringApplication.run(GamasterApplication.class, args);
		inicia();
	}

	public static void inicia() {
		String opcao = "";
		Scanner scanner = new Scanner(System.in);
		while (!opcao.equalsIgnoreCase("3")) {
			System.out.println("======== GAMASTER BANKING ========");
			System.out.println("[1] - Criar Conta\n" + "[2] - Acessar Conta\n" + "[3] - Encerrar");
			System.out.printf("Digite a opção desejada: ");

			opcao = scanner.next();

			switch (opcao) {
			case "1":
				criarConta();
				break;
			case "2":
				acessarConta();
				break;
			case "3":
				System.out.println("Obrigado por usar o sistema!");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
		scanner.close();
	}

	public static void criarConta() {
		System.out.println("Passou Aqui");
		Cliente cliente = new Cliente();
		Conta conta = null;

		cliente.setNome(campoCadastro("DIGITE O NOME DO CLIENTE: "));
		cliente.setCnpjCpf(campoCadastro("DIGITE O CPF/CNPJ DO CLIENTE: "));
		cliente.setTelefone(campoCadastro("DIGITE O TELEFONE DO CLIENTE: "));

		if (cliente.getCnpjCpf().length() == 14) {
			conta = new ContaEspecial(BigDecimal.ZERO, AGENCIA, UUID.randomUUID().toString(), new CartaoCredito(),
					cliente, BigDecimal.valueOf(10000));
		} else {
			conta = new ContaCorrente(BigDecimal.ZERO, AGENCIA, UUID.randomUUID().toString(), new CartaoCredito(),
					cliente);
		}
		// testes de saldo
		conta.depositar(BigDecimal.valueOf(10123));

		contaList.add(conta);
		// main(new String[] { "2" });
	}

	public static void acessarConta() {
		Scanner scanner = new Scanner(System.in);
		String opcao = "";
		System.out.println("======== GAMASTER BANKING ========");
		System.out.printf("Digite o CPF/CNPJ para acessar a conta:\n\n");
		String cpfCnpj = scanner.nextLine();
		Conta conta = buscarConta(cpfCnpj);

		if (conta == null) {
			System.out.println("Conta não encontrada!");
		} else {
			while (!opcao.equalsIgnoreCase("6")) {
				System.out.println("[1] - Consultar Saldo\n" + "[2] - Consultar Extrato\n" + "[3] - Realizar Depósito\n"
						+ "[4] - Realizar Saque\n" + "[5] - Realizar Tranferência\n" + "[6] - Sair da conta");
				System.out.print("\nDigite a opção desejada: ");
				opcao = scanner.next();

				switch (opcao) {
				case "1":
					System.out.printf("Saldo da Conta: R$ %.2f%n", GerenciaContas.consultarSaldo(conta));
					break;
				case "2":
					List<Movimentacao> movimentacoes = GerenciaContas.consultarExtrato(conta);
					movimentacoes.forEach(System.out::println);
					break;
				case "3":
					System.out.print("Digite o valor a ser depositado: ");
					GerenciaContas.inserir(conta, scanner.nextBigDecimal());
					break;
				case "4":
					//acessarConta();
					break;
				case "5":
					//acessarConta();
					break;
				case "6":
					System.out.println("Saindo da conta...\n");
					break;
				default:
					System.out.println("Opção inválida\n");
					break;
				}
			}
		}
	}

	public static Conta buscarConta(String cpfCnpj) {
		Optional<Conta> contaEncontrada = contaList.stream().filter((conta) -> {
			return conta.getCliente().getCnpjCpf().equalsIgnoreCase(cpfCnpj);
		}).distinct().findFirst();

		return contaEncontrada.orElse(null);
	}

	public static String campoCadastro(String texto) {
		String campo;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(texto);
			campo = scanner.nextLine();
			if (!campo.isEmpty() && campo != null) {
				break;
			}
		}
		return campo;
	}
}
