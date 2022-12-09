package classroom_25.views;

import classroom_25.controllers.GeneroController;
import classroom_25.controllers.LivroController;
import classroom_25.models.Genero;
import classroom_25.models.Livro;
import classroom_25.services.Receber;
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
        System.out.println("(2) Generor");
        System.out.print("Informe a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1:
                LivroController.addLivro(LivroController.cadastrar());
                break;
            case 2:
                GeneroController.addGenero(GeneroController.cadastrar());
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
        System.out.println("(2) Generor");
        System.out.print("Informe a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1:
                ArrayList<Livro> livros = LivroController.getAll();
                System.out.println("----------Livros-----------");
                if (livros.isEmpty()) {
                    System.out.println("\nNão há Livros Cadastrados!!!\n");
                } else {
                    for (Livro l : livros) {
                        System.out.println("ID: " + l.getIdLivro());
                        System.out.println("Título: " + l.getTitulo());
                        System.out.println("Gênero: " + l.getGenero());
                        System.out.println("Autor(es): " + l.getAutor());
                        System.out.println("Preço: " + l.getPreco());
                        System.out.println("-----------------------------\n");

                    }
                }
                break;
            case 2:
                ArrayList<Genero> genero = GeneroController.getAll();
                System.out.println("----------Livros-----------");
                if (genero.isEmpty()) {
                    System.out.println("\nNão há Livros Cadastrados!!!\n");
                } else {
                    for (Genero g : genero) {
                        System.out.println("ID: " + g.getId());
                        System.out.println("Título: " + g.getNome());

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
