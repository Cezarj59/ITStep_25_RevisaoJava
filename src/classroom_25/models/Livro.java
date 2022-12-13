package classroom_25.models;

public class Livro {

    private int id;
    private String titulo;
    private int idGenero;
    private String genero;
    private String autor;
    private double preco;

    public Livro() {
    }

    //cadastrar
    public Livro(String titulo, int idGenero, String autor, double preco) {
        this.titulo = titulo;
        this.idGenero = idGenero;
        this.autor = autor;
        this.preco = preco;
    }

    //consultar
    public Livro(int idLivro, String titulo, String genero, String autor, double preco) {
        this.id = idLivro;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
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

    @Override
    public String toString() {
        return "\nID Livro: " + id + "\nTitulo: " + titulo + "\nGenêro: " + genero + "\nAutor: " + autor + "\nPreço: " + preco;
    }

}
