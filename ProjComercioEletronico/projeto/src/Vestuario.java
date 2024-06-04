// classe produto herdando vestuario
public class Vestuario extends Produto {
    private String tamanho;
    private String cor;

    // Construtor 
    public Vestuario(String nome, double preco, String descricao, int quantidadeEmEstoque, String tamanho, String cor) {
        super(nome, preco, descricao, quantidadeEmEstoque);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    // Getters e Setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o produto
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return super.toString() + String.format(", Tamanho: %s, Cor: %s", tamanho, cor);
    }
}