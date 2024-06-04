import java.util.*;

public class SistemaEcommerce {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;
    private Scanner scanner;

    public SistemaEcommerce() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        //enquanto for diferente de 5 ele vai gerar o menu. Se for igual a 5 ele fecha o sistema
        while (opcao != 5) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1: 
                gerenciarProdutos();
                break;
                case 2:
                gerenciarClientes();
                break;
                case 3:
                gerenciarPedidos();
                break;
                case 4:
                listarEstoque();
                break;
                case 5:
                System.out.println("\nSistema encerrado!");
                break;
                default:
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\nSistema de Comércio Eletrônico");
        System.out.println("1. Gerenciar Produtos");
        System.out.println("2. Gerenciar Clientes");
        System.out.println("3. Gerenciar Pedidos");
        System.out.println("4. Listar Estoque");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Métodos para gerenciar produtos
    private void gerenciarProdutos() {
        int opcao = 0;
        while (opcao != 5) {
            exibirMenuProdutos();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1:
                adicionarProduto();
                break;
                case 2:
                listarProdutos();
                break;
                case 3:
                atualizarProduto();
                break;
                case 4:
                removerProduto();
                break;
                case 5:
                System.out.println("# Voltando ao menu principal #");
                break;
                default:
                System.out.println("Opção invalida! Tente novamente.");
            }
        }
    }

    // Exibe o menu de produtos
    private void exibirMenuProdutos() {
        System.out.println("\nGerenciamento de Produtos");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Listar Produtos");
        System.out.println("3. Atualizar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    // Metodo responsavel para add produtos
    private void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Digite a categoria do produto (1. Eletronico, 2. Vestuario, 3. Alimento): ");
        int categoria = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Produto produto = null;
        switch (categoria) {
            case 1:
                //Usa o scanner para receber a marca e modelo do produto
                System.out.print("Digite a marca do produto: ");
                String marca = scanner.nextLine();
                System.out.print("Digite o modelo do produto: ");
                String modelo = scanner.nextLine();
                produto = new Eletronico(nome, preco, descricao, quantidade, marca, modelo);
                break;
            case 2:
                //Usa o scanner para receber o tamanho e a cor
                System.out.print("Digite o tamanho do produto: ");
                String tamanho = scanner.nextLine();
                System.out.print("Digite a cor do produto: ");
                String cor = scanner.nextLine();
                produto = new Vestuario(nome, preco, descricao, quantidade, tamanho, cor);
                break;
            case 3:
                //Usa o scanner para receber a data de validade e se o produto é perecivel
                System.out.print("Digite a data de validade do produto: ");
                String dataValidade = scanner.nextLine();
                System.out.print("O produto é perecível? (true/false): ");
                boolean isPerecivel = scanner.nextBoolean();
                produto = new Alimento(nome, preco, descricao, quantidade, dataValidade, isPerecivel);
                break;
            default:
                //Se o usuario mandar alguma coisa que não seja relacionado ao Ecommerce ele diz q ta invalido
                System.out.println("Categoria inválida!");
                return;
        }
        //Adiciona o produto
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Lista os produtos por meio de um for each
    private void listarProdutos() {
        System.out.println("\nLista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    // atualiza os produtos da lista
    private void atualizarProduto() {
        System.out.print("Digite o nome do produto a ser atualizado: ");
        String nome = scanner.nextLine();
        Produto produto = encontrarProdutoPorNome(nome);
        //verifica se o produto está vazio
        if (produto != null) {
            System.out.print("Digite o novo preço do produto: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha
            System.out.print("Digite a nova descrição do produto: ");
            String descricao = scanner.nextLine();
            System.out.print("Digite a nova quantidade em estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            produto.setPreco(preco);
            produto.setDescricao(descricao);
            produto.setQuantidadeEmEstoque(quantidade);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
    // Metodo que remove um produto
    private void removerProduto() {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = scanner.nextLine();
        Produto produto = encontrarProdutoPorNome(nome);
        //verifica se o produto está vazio
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Metodo para encontrar o produto por nome na lista
    // usa um for each p/ iterar sobre todos os produtos na lista produtos
    //Para cada produto ele compara o nome do produto com o nome fornecido
    // usando o método equalsIgnoreCase(IGNORA LETRAS MAIUSCULAS E MINUSCULAS).

    private Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    // Metodos para gerenciar clientes
    private void gerenciarClientes() {
        int opcao = 0;
        // continua executando enquanto opcao for diferente de 5.
        // o loop termina qnd o usuario escolhe a opção 5 q representa "Voltar ao menu principal"
        while (opcao != 5) {
            exibirMenuClientes();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1:
                adicionarCliente();
                break;
                case 2:
                listarClientes();
                break;
                case 3:
                atualizarCliente();
                break;
                case 4:
                removerCliente();
                break;
                case 5:
                System.out.println("Voltando ao menu principal!");
                break;
                default:
                System.out.println("Opção invalida! Tente novamente.");
            }
        }
    }
    
    // exibe o menu de clientes
    private void exibirMenuClientes() {
        System.out.println("\nGerenciamento de Clientes");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }
    
    // adiciona clientes
    private void adicionarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o contato do cliente: ");
        String contato = scanner.nextLine();

        // cria um objetp do cliente e é armazenado na variável cliente.
        Cliente cliente = new Cliente(nome, endereco, contato);
        clientes.add(cliente);// adiciona o objeto cliente a lista clientes
        System.out.println("Cliente adicionado com sucesso!");
    }

    // metodo que lista os clientes usando um for each 
    private void listarClientes() {
        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // metodo que atualiza o cliente
    private void atualizarCliente() {
        System.out.print("Digite o nome do cliente a ser atualizado: ");
        String nome = scanner.nextLine();
        // Chama o método encontrarClientePorNome para encontrar o cliente com o nome fornecido.
        Cliente cliente = encontrarClientePorNome(nome);

        // Verifica se o cliente foi encontrado. Se cliente não for null, o cliente foi encontrado.
        if (cliente != null) {
            System.out.print("Digite o novo endereço do cliente: ");
            String endereco = scanner.nextLine();
            System.out.print("Digite o novo contato do cliente: ");
            String contato = scanner.nextLine();

            cliente.setEndereco(endereco);
            cliente.setContato(contato);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // Metodo que remove o cliente da lista
    private void removerCliente() {
        System.out.print("Digite o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        // Chama o método encontrarClientePorNome para encontrar o cliente com o nome fornecido.
        Cliente cliente = encontrarClientePorNome(nome);
        // Verifica se o cliente foi encontrado. Se cliente não for null, o cliente foi encontrado.
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // metodo para encontrar cliente por nome em um laço for each
    private Cliente encontrarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            //o metodo equalsIgonoreCase ignora a diferenca entre caixa alta e baixa
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    // Metodos para gerenciar pedidos
    private void gerenciarPedidos() {
        int opcao = 0;
        while (opcao != 5) {
            exibirMenuPedidos();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcao) {
                case 1:
                criarPedido();
                break;
                case 2:
                listarPedidos();
                break;
                case 3:
                atualizarStatusPedido();
                break;
                case 4:
                removerPedido();
                break;
                case 5:
                System.out.println("Voltando ao menu principal...");
                break;
                default:
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void exibirMenuPedidos() {
        System.out.println("\nGerenciamento de Pedidos");
        System.out.println("1. Criar Pedido");
        System.out.println("2. Listar Pedidos");
        System.out.println("3. Atualizar Status do Pedido");
        System.out.println("4. Remover Pedido");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    // metodo que cria pedido
    private void criarPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarClientePorNome(nomeCliente);
        // se o cliente for diferente de vazio ele cria um novo objeto pedido
        if (cliente != null) {
            Pedido pedido = new Pedido(cliente);
            int opcao = 0;
            // enquanto for diferente de 3 ele add um pedido ou remove,senão ele finaliza o laço escolhendo 3
            while (opcao != 3) {
                System.out.println("\n1. Adicionar Item ao Pedido");
                System.out.println("2. Remover Item do Pedido");
                System.out.println("3. Finalizar Pedido");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha
                switch (opcao) {
                    case 1:
                    adicionarItemPedido(pedido);
                    break;
                    case 2:
                    removerItemPedido(pedido);
                    break;
                    case 3:
                        pedidos.add(pedido);
                        cliente.adicionarPedido(pedido);
                        System.out.println("Pedido criado com sucesso!");
                        break;
                    default:
                    System.out.println("Opção invalida! Tente novamente.");
                }
            }
        } else {
            System.out.println("Cliente nao encontrado!");
        }
    }

    // metodo que adiciona item pedido
    private void adicionarItemPedido(Pedido pedido) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        Produto produto = encontrarProdutoPorNome(nomeProduto);
        // se o produto for diferente de null 
        if (produto != null) {
            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (quantidade <= produto.getQuantidadeEmEstoque()) {
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
                ItemPedido itemPedido = new ItemPedido(produto, quantidade); // cria um novo objeto ItemPedido
                pedido.adicionarItem(itemPedido);
                System.out.println("Item adicionado ao pedido!");
            } else {
                System.out.println("Quantidade insuficiente em estoque!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // metodo que remove item pedido 
    private void removerItemPedido(Pedido pedido) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        Produto produto = encontrarProdutoPorNome(nomeProduto);
        // se o produto for diferente de null
        if (produto != null) {
            ItemPedido itemParaRemover = null;
            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                    itemParaRemover = item;
                    break;
                }
            }
            // se o itemParaRemover for diferente de null
            if (itemParaRemover != null) {
                pedido.removerItem(itemParaRemover);
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + itemParaRemover.getQuantidade());
                System.out.println("Item removido do pedido!");
            } else {
                System.out.println("Item nao encontrado no pedido!");
            }
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }
    // printa a lista de pedidos
    private void listarPedidos() {
        System.out.println("\nLista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    // Metodo para atualizar 
    private void atualizarStatusPedido() {
        System.out.print("Digite o nome do cliente do pedido: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarClientePorNome(nomeCliente);
        // se o cliente for diferente de null ele executa pedindo o nmr do pedido 
        if (cliente != null) {
            System.out.print("Digite o índice do pedido a ser atualizado (começando em 0): ");
            int indicePedido = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            if (indicePedido >= 0 && indicePedido < cliente.getHistoricoPedidos().size()) {
                Pedido pedido = cliente.getHistoricoPedidos().get(indicePedido);
                System.out.print("Digite o novo status do pedido: ");
                String novoStatus = scanner.nextLine();
                pedido.setStatus(novoStatus);
                System.out.println("Status do pedido atualizado com sucesso!");
            } else {
                System.out.println("Indice de pedido invalido!");
            }
        } else {
            System.out.println("Cliente nao encontrado!");
        }
    }

    // metodo que remove o pedido
    private void removerPedido() {
        System.out.print("Digite o nome do cliente do pedido: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarClientePorNome(nomeCliente);
        // se o cliente for diferente de vazio ele executa 
        if (cliente != null) {
            System.out.print("Digite o indice do pedido a ser removido (começando em 0): ");
            int indicePedido = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            // verifica se o indice do pedido a ser removido está dentro dos limites validos do
            // histórico de pedidos do cliente
            if (indicePedido >= 0 && indicePedido < cliente.getHistoricoPedidos().size()) {
                Pedido pedido = cliente.getHistoricoPedidos().get(indicePedido);
                //Remove o pedido do histórico de pedidos do cliente com base no índice fornecido.
                cliente.getHistoricoPedidos().remove(indicePedido);
                pedidos.remove(pedido);
                // Itera sobre todos os itens do pedido removido.
                for (ItemPedido item : pedido.getItens()) {
                    Produto produto = item.getProduto();
                    produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + item.getQuantidade());
                }
                System.out.println("Pedido removido com sucesso!");
            } else {
                System.out.println("Indice de pedido invalido!");
            }
        } else {
            System.out.println("Cliente nao encontrado!");
        }
    }

    private void listarEstoque() {
        System.out.println("\nEstoque de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    public static void main(String[] args) {
        SistemaEcommerce sistema = new SistemaEcommerce();
        sistema.iniciar();
    }

}