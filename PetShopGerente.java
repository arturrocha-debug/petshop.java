package cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetShopGerente {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Servico> servicosDisponiveis = new ArrayList<>();
    private List<Contratacao> contratacoes = new ArrayList<>();

    public PetShopGerente() {
        servicosDisponiveis.add(new BanhoETosa());
    }

    public void cadastrarCliente(String nome, String telefone, String email) {
        clientes.add(new Cliente(nome, telefone, email));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
    
    public Optional<Cliente> buscarClientePorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void cadastrarPet(int idCliente, String nome, String especie, String raca, int idade, double peso) {
        Optional<Cliente> clienteOpt = buscarClientePorId(idCliente);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            Pet novoPet = new Pet(nome, especie, raca, idade, peso);
            cliente.adicionarPet(novoPet);
            System.out.println("Pet '" + nome + "' cadastrado para o cliente '" + cliente.getNome() + "'.");
        } else {
            System.out.println("Erro: Cliente com ID " + idCliente + " não encontrado.");
        }
    }

    public List<Servico> getServicosDisponiveis() {
        return servicosDisponiveis;
    }
    
    public void contratarServico(int idCliente, int idPet, int indiceServico, LocalDate data) {
        Optional<Cliente> clienteOpt = buscarClientePorId(idCliente);
        if (clienteOpt.isEmpty()) {
            System.out.println("Erro: Cliente não encontrado.");
            return;
        }

        Cliente cliente = clienteOpt.get();
        Optional<Pet> petOpt = cliente.getPets().stream().filter(p -> p.getId() == idPet).findFirst();

        if (petOpt.isEmpty()) {
            System.out.println("Erro: Pet não encontrado ou não pertence a este cliente.");
            return;
        }
        
        if (indiceServico < 0 || indiceServico >= servicosDisponiveis.size()) {
            System.out.println("Erro: Serviço inválido.");
            return;
        }

        Pet pet = petOpt.get();
        Servico servico = servicosDisponiveis.get(indiceServico);
        
        contratacoes.add(new Contratacao(cliente, pet, servico, data));
        System.out.println("Serviço contratado com sucesso!");
    }
    
    public List<Contratacao> listarContratacoes() {
        return contratacoes;
    }
}
