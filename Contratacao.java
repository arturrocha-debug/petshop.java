package cliente;

import java.time.LocalDate;

public class Contratacao {
    private static int contadorId = 1;
    private int id;
    private Cliente cliente;
    private Pet pet;
    private Servico servico;
    private LocalDate dataRealizacao;

    public Contratacao(Cliente cliente, Pet pet, Servico servico, LocalDate dataRealizacao) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.pet = pet;
        this.servico = servico;
        this.dataRealizacao = dataRealizacao;
    }

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Pet getPet() { return pet; }
    public Servico getServico() { return servico; }
    public LocalDate getDataRealizacao() { return dataRealizacao; }
    
    @Override
    public String toString() {
        return "Contratação ID: " + id + 
               "\n  Data: " + dataRealizacao +
               "\n  Cliente: " + cliente.getNome() + 
               "\n  Pet: " + pet.getNome() + 
               "\n  " + servico.toString();
    }
}
