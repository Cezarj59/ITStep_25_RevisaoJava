package classroom_25.controllers;

import classroom_25.models.Genero;
import classroom_25.services.BancoDados;
import classroom_25.services.Receber;
import java.util.ArrayList;
import java.sql.*;

public class GeneroController {

   
    public static Genero cadastrar() {
        System.out.println("\nCADASTRAR NOVO GÊNERO\n");
        System.out.println("Innforme o novo gênero: ");

        return new Genero(Receber.texto());
    }

    public static void addGenero(Genero g) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO genero (nome) VALUES (?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, g.getNome());

            if (statement.executeUpdate() > 0) {
                System.out.println("\nGênero Cadastrado com Sucesso!!!\n");
            } else {
                System.out.println("\nFalha ao Cadastrar um novo Gênero!!!\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);

    }
    
     public static ArrayList<Genero> getAll() {
        ArrayList<Genero> lista = new ArrayList<Genero>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM genero";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new Genero(
                        resultado.getInt("id"),
                        resultado.getString("nome")
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }

}
