import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Locadora
{
    // Esse aqui será nosso "Banco de dados" em memória kkkk
    private static List<Midia> catalogo = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Aqui a gente add os dados iniciais para testar o programa
        inicializarDados();

        int opcao;
        do
        {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao)
            {
                case 1: cadastrarMidia(); break;
                case 2: cadastrarCliente(); break;
                case 3: realizarEmprestimo(); break;
                case 4: realizarDevolucao(); break;
                case 5: listarCatalogo(); break;
                case 6: listarClientes(); break;
                case 7: Relatorio.gerarRelatorioGeral(catalogo, clientes, emprestimos); break;
                case 8: Relatorio.listarMidiasDisponiveis(catalogo); break;
                case 9: Relatorio.exibirDetalhesMidias(catalogo); break;
                case 10: Relatorio.listarMidiasPorTipo(catalogo); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu()
    {
        System.out.println("\n===== LOCADORA DE MÍDIAS =====");
        System.out.println("1. Cadastrar mídia");
        System.out.println("2. Cadastrar cliente");
        System.out.println("3. Realizar empréstimo");
        System.out.println("4. Realizar devolução");
        System.out.println("5. Listar catálogo completo");
        System.out.println("6. Listar clientes");
        System.out.println("7. Relatório geral");
        System.out.println("8. Listar mídias disponíveis");
        System.out.println("9. Exibir detalhes das mídias (Polimorfismo)");
        System.out.println("10. Distribuição por tipo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inicializarDados()
    {
        // Cadastrar algumas mídias
        catalogo.add(new Filme("O Poderoso Chefão", 1972, "Francis Ford Coppola", 175));
        catalogo.add(new Filme("Matrix", 1999, "Lana e Lilly Wachowski", 136));
        catalogo.add(new Serie("Breaking Bad", 2008, 5, "Vince Gilligan"));
        catalogo.add(new Serie("Stranger Things", 2016, 4, "The Duffer Brothers"));

        // Cadastrar alguns clientes
        clientes.add(new Cliente("João Silva", "joao@email.com", "(85) 99999-1111"));
        clientes.add(new Cliente("Maria Santos", "maria@email.com", "(85) 98888-2222"));

        // Cadastrar funcionário (exemplo de uso)
        Funcionario func = new Funcionario("Carlos", "carlos@locadora.com", "Atendente");
        System.out.println("Funcionário cadastrado: " + func.getTipoPessoa());

        System.out.println("\nDados iniciais carregados com sucesso!");
        System.out.println("Total de pessoas no sistema: " + Pessoa.getTotalPessoas());
        System.out.println("Total de mídias no sistema: " + Midia.getTotalMidias());
    }

    private static void cadastrarMidia()
    {
        System.out.println("\n=== CADASTRAR MÍDIA ===");
        System.out.print("Tipo (1-Filme, 2-Série): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1)
        {
            System.out.print("Diretor: ");
            String diretor = scanner.nextLine();

            System.out.print("Duração (minutos): ");
            int duracao = scanner.nextInt();

            Filme filme = new Filme(titulo, ano, diretor, duracao);
            catalogo.add(filme);
            System.out.println("Filme cadastrado com ID: " + filme.getId());
        } else
        {
            System.out.print("Número de temporadas: ");
            int temporadas = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Criador: ");
            String criador = scanner.nextLine();

            Serie serie = new Serie(titulo, ano, temporadas, criador);
            catalogo.add(serie);
            System.out.println("Série cadastrada com ID: " + serie.getId());
        }
    }

    private static void cadastrarCliente()
    {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com ID: " + cliente.getId());
    }

    private static void realizarEmprestimo()
    {
        System.out.println("\n=== REALIZAR EMPRÉSTIMO ===");

        if (clientes.isEmpty() || catalogo.isEmpty())
        {
            System.out.println("É necessário ter clientes e mídias cadastrados!");
            return;
        }

        // Listar clientes
        System.out.println("Clientes disponíveis:");
        for (Cliente c : clientes)
        {
            System.out.println(c.getId() + ". " + c.getNome());
        }

        System.out.print("Escolha o ID do cliente: ");
        int idCliente = scanner.nextInt();

        // Listar mídias disponíveis
        System.out.println("\nMídias disponíveis:");
        catalogo.stream()
                .filter(Midia::isDisponivel)
                .forEach(m -> System.out.println(m.getId() + ". " + m.getTitulo()));

        System.out.print("Escolha o ID da mídia: ");
        int idMidia = scanner.nextInt();

        // Buscar cliente e mídia
        Cliente cliente = clientes.stream()
                .filter(c -> c.getId() == idCliente)
                .findFirst()
                .orElse(null);

        Midia midia = catalogo.stream()
                .filter(m -> m.getId() == idMidia && m.isDisponivel())
                .findFirst()
                .orElse(null);

        if (cliente != null && midia != null)
        {
            Emprestimo emp = new Emprestimo(cliente, midia);
            emprestimos.add(emp);
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println("ID do empréstimo: " + emp.getId());
            System.out.println("Data de devolução: " + emp.getDataDevolucao());
        } else {
            System.out.println("Cliente ou mídia não encontrados!");
        }
    }

    private static void realizarDevolucao()
    {
        System.out.println("\n=== REALIZAR DEVOLUÇÃO ===");

        // Listando empréstimos ativos
        List<Emprestimo> ativos = emprestimos.stream()
                .filter(e -> !e.isFinalizado())
                .toList();

        if (ativos.isEmpty()) {
            System.out.println("Não há empréstimos ativos!");
            return;
        }

        System.out.println("Empréstimos ativos:");
        ativos.forEach(e -> System.out.println(e.getId() + ". " + e.getCliente().getNome() +
                " - " + e.getMidia().getTitulo()));

        System.out.print("Escolha o ID do empréstimo: ");
        int idEmp = scanner.nextInt();

        Emprestimo emp = ativos.stream()
                .filter(e -> e.getId() == idEmp)
                .findFirst()
                .orElse(null);

        if (emp != null)
        {
            double multa = emp.finalizarEmprestimo();
            if (multa > 0)
            {
                System.out.println("Devolução com atraso! Multa: R$ " + multa);
            } else
            {
                System.out.println("Devolução realizada no prazo!");
            }
        } else
        {
            System.out.println("Empréstimo não encontrado!");
        }
    }

    private static void listarCatalogo()
    {
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        catalogo.forEach(System.out::println);
    }

    private static void listarClientes()
    {
        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        clientes.forEach(c -> System.out.println(c.getId() + ". " + c.getNome() +
                " (" + c.getTipoPessoa() + ")"));
    }
}