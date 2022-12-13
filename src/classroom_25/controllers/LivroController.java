package classroom_25.controllers;

import classroom_25.models.Genero;
import classroom_25.models.Livro;
import classroom_25.services.BancoDados;
import classroom_25.services.Receber;
import java.util.ArrayList;
import java.sql.*;

public class LivroController {

    public static Livro cadastrar() {
        Livro l = new Livro();
        System.out.println("\n----------CADASTRAR NOVO LIVRO----------\n");

        System.out.print("Informe o título: ");
        l.setTitulo(Receber.texto());

        System.out.println("Gêneros: ");
        ArrayList<Genero> lista = GeneroController.getAll();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + lista.get(i).getNome());
        }

        System.out.println("Informe o número referente ao gênero: ");
        l.setIdGenero(Receber.inteiro());

        System.out.print("Autor(es): ");
        l.setAutor(Receber.texto());

        System.out.print("Preço: ");
        l.setPreco(Receber.numeroDecimal());

        return l;
    }

    public static void addLivro(Livro g) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO livro (titulo,idgenero,autor,preco) VALUES (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, g.getTitulo());
            statement.setInt(2, g.getIdGenero());
            statement.setString(3, g.getAutor());
            statement.setDouble(4, g.getPreco());

            if (statement.executeUpdate() > 0) {
                System.out.println("\nLivro Cadastrado com Sucesso!!!\n");
            } else {
                System.out.println("\nFalha ao Cadastrar o Livro!!!\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);

    }

    public static ArrayList<Livro> getAll() {
        ArrayList<Livro> lista = new ArrayList<Livro>();

        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT livro.id AS idlivro,"
                    + " livro.titulo AS titulo,"
                    + " genero.nome  AS genero,"
                    + " livro.autor  AS autor,"
                    + " livro.preco  AS preco"
                    + " FROM livro INNER JOIN genero"
                    + " ON livro.idGenero = genero.id";

            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new Livro(
                        resultado.getInt("idlivro"),
                        resultado.getString("titulo"),
                        resultado.getString("genero"),
                        resultado.getString("autor"),
                        resultado.getDouble("preco")
                )
                );

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }
}
