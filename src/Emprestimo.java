import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo
{
    private int id;
    private Cliente cliente;
    private Midia midia;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean finalizado;
    private static int contadorEmprestimos = 0;

    public Emprestimo(Cliente cliente, Midia midia)
    {
        this.id = ++contadorEmprestimos;
        this.cliente = cliente;
        this.midia = midia;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(7); // 7 dias para devolver
        this.finalizado = false;
        midia.setDisponivel(false);
    }

    // Getters
    public int getId()
    {
        return id;
    }
    public Cliente getCliente()
    {
        return cliente;
    }
    public Midia getMidia()
    {
        return midia;
    }
    public LocalDate getDataEmprestimo()
    {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao()
    {
        return dataDevolucao;
    }
    public boolean isFinalizado()
    {
        return finalizado;
    }

    // Devolução de mídias
    public double finalizarEmprestimo()
    {
        if (finalizado) return 0;

        this.finalizado = true;
        midia.setDisponivel(true);

        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao))
        {
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, hoje);
            // POLIMORFISMO: chamada ao método calcularMulta específico de cada tipo de mídia
            return midia.calcularMulta((int) diasAtraso);
        }
        return 0;
    }

    @Override
    public String toString()
    {
        String status = finalizado ? "Devolvido" : "Em andamento";
        return "Empréstimo #" + id + " - " + cliente.getNome() + " - " +
                midia.getTitulo() + " - " + status;
    }
}