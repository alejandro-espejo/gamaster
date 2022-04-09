package br.edu.gama.gamaster;

import br.edu.gama.gamaster.model.*;
import br.edu.gama.gamaster.service.GerenciaContas;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;


@SpringBootApplication
public class GamasterApplication {
    public static List<Conta> contaList = new ArrayList<>();
    public static final String AGENCIA = "1500";

    public static void main(String[] args) {
        // Comentado para o Spring não tentar fazer a conexão com o banco por enquanto
//		SpringApplication.run(GamasterApplication.class, args);

        inicia();

    }

    public static void inicia(){
        System.out.println("======== GAMASTER BANKING ========");
        System.out.println("[1] - Criar Conta\n" +
                "[2] - Acessar Conta");
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a opção desejada: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                acessarConta();
                break;
            default:
                break;
        }
    }

    public static void criarConta(){
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Conta conta = null;

        System.out.print("DIGITE O NOME DO CLIENTE:");
        cliente.setNome(sc.nextLine());
        System.out.print("DIGITE O CPF/CNPJ DO CLIENTE:");
        cliente.setCnpjCpf(sc.nextLine());
        System.out.print("DIGITE O TELEFONE DO CLIENTE:");
        cliente.setTelefone(sc.nextLine());

        if(cliente.getCnpjCpf().length() == 14){
            conta = new ContaEspecial(BigDecimal.ZERO, AGENCIA, UUID.randomUUID().toString(),
                    new CartaoCredito(), cliente, BigDecimal.valueOf(10000));
        }else{
            conta = new ContaCorrente(BigDecimal.ZERO, AGENCIA, UUID.randomUUID().toString(),
                    new CartaoCredito(), cliente);
        }
        //testes de saldo
        conta.depositar(BigDecimal.valueOf(10123));

        contaList.add(conta);
        main(new String[]{"2"});

    }

    public static void acessarConta(){
        System.out.println("======== GAMASTER BANKING ========");
        System.out.print("Digite o CPF/CNPJ para acessar a conta: ");
        Scanner sc = new Scanner(System.in);
        String cpfCnpj = sc.nextLine();
        Conta conta = buscarConta(cpfCnpj);

//        main(new String[]{"2"});

        System.out.println("[1] - Consultar Saldo\n" +
                "[2] - Consultar Extrato\n" +
                "[3] - Realizar Depósito\n" +
                "[4] - Realizar Saque\n" +
                "[5] - Realizar Tranferência");
        System.out.print("\nDigite a opção desejada: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.printf("Saldo da Conta: R$ %.2f%n",GerenciaContas.consultarSaldo(conta));
                break;
            case 2:
                List<Movimentacao> movimentacoes = GerenciaContas.consultarExtrato(conta);
                movimentacoes.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Digite o valor a ser depositado: ");
                GerenciaContas.inserir(conta, sc.nextBigDecimal());
                break;
            case 4:
                acessarConta();
                break;
            case 5:
                acessarConta();
                break;
            default:
                break;
        }
        acessarConta();
    }

    public static Conta buscarConta(String cpfCnpj){
        Optional<Conta> contaEncontrada = contaList.stream().filter((conta)->{
            return conta.getCliente().getCnpjCpf().equalsIgnoreCase(cpfCnpj);
        }).distinct().findFirst();

        return contaEncontrada.orElse(null);
    }
}
