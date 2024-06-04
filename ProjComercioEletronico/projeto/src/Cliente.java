import java.util.*;
public class Cliente {
    private String nome;
    private String endereco;
    private String contato;
    private List<Pedido> historicoPedidos;

    // construtor
    public Cliente(String nome, String endereco, String contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.historicoPedidos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.historicoPedidos.add(pedido);
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o CLIENTE
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return String.format("Cliente: %s, Endereço: %s, Contato: %s, Histórico de Pedidos: %d",
        nome, endereco, contato, historicoPedidos.size());
    }
}