public class Filme extends Midia
{
    private String diretor;
    private int duracaoMinutos;

    public Filme(String titulo, int ano, String diretor, int duracaoMinutos)
    {
        super(titulo, ano);
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getDiretor()
    {
        return diretor;
    }
    public void setDiretor(String diretor)
    {
        this.diretor = diretor;
    }
    public int getDuracaoMinutos()
    {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracao)
    {
        this.duracaoMinutos = duracao;
    }

    @Override
    public String getTipo()
    {
        return "Filme";
    }

    @Override
    public double calcularMulta(int diasAtraso)
    {
        // Filme: R$ 2,50 por dia de atraso
        return diasAtraso * 2.50;
    }

    @Override
    public String toString()
    {
        return id + " - " + titulo + " (" + ano + ") - Dir: " + diretor + " - " + duracaoMinutos + "min";
    }
}