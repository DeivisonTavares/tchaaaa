public class Alimento extends Produto {
    private String dataValidade;
    private boolean isPerecivel;

    // construtor
    public Alimento(String nome, double preco, String descricao, int quantidadeEmEstoque, String dataValidade, boolean isPerecivel) {
        super(nome, preco, descricao, quantidadeEmEstoque);
        this.dataValidade = dataValidade;
        this.isPerecivel = isPerecivel;
    }

    // Getters e Setters
    public String getDataValidade(){
        return dataValidade;
    }

    public void setDataValidade(String dataValidade){
        this.dataValidade = dataValidade;
    }

    public boolean isPerecivel() {
        return isPerecivel;
    }
    
    public void setPerecivel(boolean isPerecivel) {
        this.isPerecivel = isPerecivel;
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o ALIMENTO
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return super.toString() + String.format(", Data de Validade: %s, Perecível: %b", dataValidade, isPerecivel);
    }
}