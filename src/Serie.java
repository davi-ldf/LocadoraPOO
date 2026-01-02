public class Serie extends Midia
{
    private int temporadas;
    private String criador;

    public Serie(String titulo, int ano, int temporadas, String criador)
    {
        super(titulo, ano);
        this.temporadas = temporadas;
        this.criador = criador;
    }

    public int getTemporadas()
    {
        return temporadas;
    }
    public void setTemporadas(int temporadas)
    {
        this.temporadas = temporadas;
    }
    public String getCriador()
    {
        return criador;
    }
    public void setCriador(String criador)
    {
        this.criador = criador;
    }

    @Override
    public String getTipo()
    {
        return "Série";
    }

    @Override
    public double calcularMulta(int diasAtraso)
    {
        // Série: R$ 1,75 por dia de atraso
        return diasAtraso * 1.75;
    }

    @Override
    public String toString()
    {
        return id + " - " + titulo + " (" + ano + ") - " + temporadas + " temporadas - Criador: " + criador;
    }
}