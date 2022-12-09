package classroom_25.models;

public class Livro {

    private int idLivro;
    private String titulo;
    private int IdGenero;
    private String genero;
    private String autor;
    private double preco;

    public Livro() {
    }

    //cadastrar
    public Livro(String titulo, int IdGenero, String autor, double preco) {
        this.titulo = titulo;
        this.IdGenero = IdGenero;
        this.autor = autor;
        this.preco = preco;
    }

    //consultas
    public Livro(int idLivro, String titulo, String genero, String autor, double preco) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.preco = preco;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(int IdGenero) {
        this.IdGenero = IdGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
