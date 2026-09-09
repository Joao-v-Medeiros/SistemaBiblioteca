import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Livro> Livros = new ArrayList<>();

        Servicos servicos = new Servicos();
        boolean parar = false;
        int id_livro = 1;
        int id;

        do{
            int opcao = servicos.opcao();

            switch (opcao){
                case 1:
                    Livros.add(servicos.adicionarLivro(id_livro));
                    id_livro++;
                    break;
                case 2:
                    servicos.listarLivros(Livros);
                    break;
                case 3:
                    System.out.println("Digite o ID do livro que deseja emprestar: ");
                    id = sc.nextInt();
                    servicos.emprestarLivro(Livros,id);
                    break;
                case 4:
                    System.out.println("Digite o ID do livro que deseja devolver. ");
                    id = sc.nextInt();
                    servicos.devolverLivro(Livros,id);
                    break;
                case 5:
                    System.out.println("Digite o ID do livro que deseja remover. ");
                    id = sc.nextInt();
                    servicos.removerLivro(Livros,id);
                    break;
                case 6:
                    parar = true;
                    System.out.println("Encerrando... ");
                    break;

            }
        }while (!parar);
    }
}
