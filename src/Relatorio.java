import java.util.List;

public class Relatorio {

    private Relatorio() {}

    // Métodos de geração de relatórios
    public static void gerarRelatorioGeral(List<Midia> midias, List<Cliente> clientes, List<Emprestimo> emprestimos)
    {
        System.out.println("\n======= RELATÓRIO GERAL =======");
        System.out.println("Total de mídias cadastradas: " + midias.size());
        System.out.println("Total de clientes: " + clientes.size());
        System.out.println("Total de empréstimos realizados: " + emprestimos.size());

        long emprestimosAtivos = emprestimos.stream()
                .filter(e -> !e.isFinalizado())
                .count();
        System.out.println("Empréstimos ativos: " + emprestimosAtivos);
    }

    public static void listarMidiasDisponiveis(List<Midia> midias)
    {
        System.out.println("\n=== MÍDIAS DISPONÍVEIS ===");
        midias.stream()
                .filter(Midia::isDisponivel)
                .forEach(m -> System.out.println("• " + m));
    }

    public static void listarMidiasPorTipo(List<Midia> midias)
    {
        System.out.println("\n=== DISTRIBUIÇÃO POR TIPO ===");
        long filmes = midias.stream()
                .filter(m -> m instanceof Filme)
                .count();
        long series = midias.stream()
                .filter(m -> m instanceof Serie)
                .count();
        System.out.println("Filmes: " + filmes);
        System.out.println("Séries: " + series);
    }

    public static void exibirDetalhesMidias(List<Midia> midias)
    {
        System.out.println("\n=== DETALHES DE TODAS AS MÍDIAS ===");
        for (Midia m : midias) {
            System.out.println(m.getTipo() + ": " + m.getTitulo() +
                    " - Disponível: " + (m.isDisponivel() ? "Sim" : "Não"));
        }
    }
}