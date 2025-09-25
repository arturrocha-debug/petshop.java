package cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PetShopGerente manager = new PetShopGerente();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: cadastrarPet(); break;
                case 4: contratarServico(); break;
                case 5: listarContratacoes(); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Pet Shop ---");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Cadastrar Pet");
        System.out.println("4. Contratar Serviço");
        System.out.println("5. Listar Serviços Contratados");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        manager.cadastrarCliente(nome, telefone, email);
    }

    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = manager.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(System.out::println);
        }
    }
    
    private static void cadastrarPet() {
        listarClientes();
        System.out.print("Digite o ID do cliente dono do pet: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        
        manager.cadastrarPet(idCliente, nome, especie, raca, idade, peso);
    }

    private static void contratarServico() {
        System.out.println("\n--- Contratar Serviço ---");
        listarClientes();
        System.out.print("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        
        Cliente cliente = manager.buscarClientePorId(idCliente).orElse(null);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        System.out.println("\nPets de " + cliente.getNome() + ":");
        if (cliente.getPets().isEmpty()) {
            System.out.println("Este cliente não possui pets cadastrados.");
            return;
        }
        cliente.getPets().forEach(System.out::println);
        System.out.print("Digite o ID do pet: ");
        int idPet = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nServiços Disponíveis:");
        List<Servico> servicos = manager.getServicosDisponiveis();
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println(i + ". " + servicos.get(i));
        }
        System.out.print("Escolha o índice do serviço: ");
        int indiceServico = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Data de realização (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        manager.contratarServico(idCliente, idPet, indiceServico, data);
    }
    
    private static void listarContratacoes() {
        System.out.println("\n--- Lista de Contratações ---");
        List<Contratacao> contratacoes = manager.listarContratacoes();
        if (contratacoes.isEmpty()) {
            System.out.println("Nenhum serviço contratado.");
        } else {
            contratacoes.forEach(c -> System.out.println(c + "\n"));
        }
    }
}
