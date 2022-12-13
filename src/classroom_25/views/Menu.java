package classroom_25.views;

import classroom_25.controllers.*;
import classroom_25.models.*;
import classroom_25.services.*;
import java.util.ArrayList;

class Menu {

    protected static void inicio() {
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("----------LIVRARIA-----------");
            System.out.println("-----------------------------\n");

            System.out.println("(0) #SAIR#");
            System.out.println("(1) Cadastrar");
            System.out.println("(2) Consultar");
            System.out.print("Informe a opção desejada: ");

            switch (Receber.inteiro()) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cadastrar();
                    break;
                case 2:
                    consultar();
                    break;
                default:
                    System.out.println("\nOpção Invalida!!!\n");
                    ;
            }
        }

    }

    private static void cadastrar() {
        System.out.println("\n-----------------------------");
        System.out.println("----------CADASTRO-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Livro");
        System.out.println("(2) Genero");
        System.out.println("(3) Cliente");
        System.out.print("Informe a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1:
                LivroController.addLivro(LivroController.cadastrar());
                break;
            case 2:
                GeneroController.addGenero(GeneroController.cadastrar());
                break;
            case 3:
                ClienteController.addCliente(ClienteController.cadastrar());
                break;
            default:
                System.out.println("\nOpção Invalida!!!\n");
                ;
        }
    }

    private static void consultar() {
        System.out.println("\n-----------------------------");
        System.out.println("----------CONSULTA-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Livro");
        System.out.println("(2) Genero");
        System.out.println("(3) Cliente");
        System.out.print("Informe a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1:
                ArrayList<Livro> livros = LivroController.getAll();
                System.out.println("\n----------Livros-----------");
                if (livros.isEmpty()) {
                    System.out.println("\nNão há Livros Cadastrados!!!\n");
                } else {
                    for (Livro l : livros) {
                        System.out.println(l.toString());
                        System.out.println("-----------------------------\n");

                    }
                }
                break;
            case 2:
                ArrayList<Genero> genero = GeneroController.getAll();
                System.out.println("\n----------Gênero-----------");
                if (genero.isEmpty()) {
                    System.out.println("\nNão há Gêneros Cadastrados!!!\n");
                } else {
                    for (Genero g : genero) {
                        System.out.println(g.toString());
                        System.out.println("-----------------------------\n");
                    }
                }
                break;
            case 3:
                ArrayList<Cliente> cliente = ClienteController.getAll();
                System.out.println("\n----------Clientes-----------");
                if (cliente.isEmpty()) {
                    System.out.println("\nNão há Clientes Cadastrados!!!\n");
                } else {
                    for (Cliente c : cliente) {
                        System.out.println(c.toString());
                        System.out.println("-----------------------------\n");

                    }
                }
                break;

            default:
                System.out.println("\nOpção Invalida!!!\n");
                ;
        }
    }

}
