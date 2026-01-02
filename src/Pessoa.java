public abstract class Pessoa
{
    protected int id;
    private String nome;
    private String email;
    private static int contadorPessoas = 0;  

    public Pessoa(String nome, String email) {
        this.id = ++contadorPessoas;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public int getId()
    {
        return id;
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public static int getTotalPessoas()
    {
        return contadorPessoas;
    }

    public abstract String getTipoPessoa();
}