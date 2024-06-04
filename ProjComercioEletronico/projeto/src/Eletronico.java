public class Eletronico extends Produto {
    private String marca;
    private String modelo;

    // construtor
    public Eletronico(String nome, double preco, String descricao, int quantidadeEmEstoque, String marca, String modelo) {
        super(nome, preco, descricao, quantidadeEmEstoque);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o ELETRONICO
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return super.toString() + String.format(", Marca: %s, Modelo: %s", marca, modelo);
    }
}