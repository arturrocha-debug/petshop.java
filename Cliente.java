package cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private List<Pet> pets;

    public Cliente(String nome, String telefone, String email) {
        this.id = contadorId++;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public List<Pet> getPets() { return pets; }

    // Método para adicionar um pet à lista do cliente
    public void adicionarPet(Pet pet) {
        this.pets.add(pet);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Telefone: " + telefone + ", Pets: " + pets.size();
    }
}
