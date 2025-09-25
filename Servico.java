package cliente;

public abstract class Servico {
    protected String nome;
    protected double preco;

    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    
    @Override
    public String toString() {
        return "Serviço: " + nome + ", Preço: R$" + String.format("%.2f", preco);
    }
}
