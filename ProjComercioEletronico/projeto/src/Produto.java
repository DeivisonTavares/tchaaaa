public abstract class Produto {
    private String nome;
    private double preco;
    private String descricao;
    private int quantidadeEmEstoque;

    // construtor
    public Produto(String nome, double preco, String descricao, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters e Setters
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }


    // Utilização de POLIMORFISMO para descrever mais sobre o produto
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return String.format("Produto: %s, Preço: %.2f, Descrição: %s, Quantidade em Estoque: %d",
                nome, preco, descricao, quantidadeEmEstoque);
    }
}