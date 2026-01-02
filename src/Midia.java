public abstract class Midia
{
    protected int id;
    protected String titulo;
    protected int ano;
    private boolean disponivel;
    private static int contadorMidias = 0;

    public Midia(String titulo, int ano) {
        this.id = ++contadorMidias;
        this.titulo = titulo;
        this.ano = ano;
        this.disponivel = true;
    }

    // Getters e Setters
    public int getId()
    {
        return id;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public int getAno()
    {
        return ano;
    }
    public void setAno(int ano)
    {
        this.ano = ano;
    }
    public boolean isDisponivel()
    {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel)
    {
        this.disponivel = disponivel;
    }

    public static int getTotalMidias()
    {
        return contadorMidias;
    }

    public abstract String getTipo();
    public abstract double calcularMulta(int diasAtraso);
}