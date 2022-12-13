package classroom_25.controllers;

import classroom_25.models.Cliente;
import classroom_25.services.BancoDados;
import classroom_25.services.Receber;
import java.util.ArrayList;
import java.sql.*;

public class ClienteController {

    public static Cliente cadastrar() {
        Cliente c = new Cliente();
        System.out.println("\nCADASTRAR NOVO CLIENTE\n");

        System.out.print("Informe o nome: ");
        c.setNome(Receber.texto());

        System.out.print("Informe o CPF: ");
        c.setCpf(Receber.texto());

        System.out.print("Informe o numero do celular: ");
        c.setTelefone(Receber.texto());

        return c;
    }
    
    
      public static void addCliente(Cliente g) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO cliente (nome,cpf,telefone) VALUES (?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, g.getNome());
            statement.setString(2, g.getCpf());
            statement.setString(3, g.getTelefone());

            if (statement.executeUpdate() > 0) {
                System.out.println("\nCliente " + g.getNome() + " Cadastrado com Sucesso!!!\n");
            } else {
                System.out.println("\nFalha ao Cadastrar o Cliente!!!\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);
    }
      
      public static ArrayList<Cliente> getAll() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM cliente";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new Cliente(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("telefone")
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }

  

}
