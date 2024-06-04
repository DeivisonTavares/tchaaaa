import java.util.*;;
public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String status;
    private String infoPagamento;
    private String infoEntrega;

    // construtor
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "Novo";
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        this.itens.remove(item);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfoPagamento() {
        return infoPagamento;
    }

    public void setInfoPagamento(String infoPagamento) {
        this.infoPagamento = infoPagamento;
    }

    public String getInfoEntrega() {
        return infoEntrega;
    }
    
    public void setInfoEntrega(String infoEntrega) {
        this.infoEntrega = infoEntrega;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    // Utilização de POLIMORFISMO para descrever mais sobre o CLIENTE
    // ".format()" serve para formatar uma string usando o %tipoDeDado
    @Override
    public String toString() {
        return String.format("Pedido do Cliente: %s, Itens: %d, Status: %s, Total: %.2f",
                cliente.getNome(), itens.size(), status, calcularTotal());
    }
}
