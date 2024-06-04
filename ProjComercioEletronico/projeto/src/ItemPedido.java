public class ItemPedido {
    private Produto produto;
    private int quantidade;

    // construtor
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o ITEM
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return String.format("Item: %s, Quantidade: %d", produto.getNome(), quantidade);
    }
}