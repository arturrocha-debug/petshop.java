package cliente;

public class Pet {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        this.id = contadorId++;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca;
    }
}
