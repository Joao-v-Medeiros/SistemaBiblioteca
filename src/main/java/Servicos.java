import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Servicos {

    Scanner sc = new Scanner(System.in);

    public int opcao() {
        System.out.println("Digite a opção desejada: ");
        System.out.println("[1] Adicionar livro: ");
        System.out.println("[2] Listar livro: ");
        System.out.println("[3] Empréstimo de livro: ");
        System.out.println("[4] Devolver livro: ");
        System.out.println("[5] Excluir livro: ");
        System.out.println("[6] Encerrar programa: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public Livro adicionarLivro(int id){
        System.out.println("Digite o titulo do livro: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o nome do autor: ");
        String autor = sc.nextLine();
        System.out.println("Digite o ano de lançamemto: ");
        int ano = sc.nextInt();
        Livro livro = new Livro(id,titulo,autor,ano);
        System.out.println();
        System.out.println("Livro adicionado com sucesso! ");
        System.out.println();
        return livro;
    }

    public void listarLivros(ArrayList<Livro> livros){
        if (livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado. ");
            System.out.println();
            return;
        }
        System.out.println();
        System.out.println("Lista de livros: ");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(livros.get(i).toString());
        }
        System.out.println();
    }

    public void emprestarLivro(ArrayList<Livro> livros, int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                if (livro.getDisponibilidade()){
                    livro.setDisponibilidade(false);
                    System.out.println();
                    System.out.println("livro emprestado com sucesso! " + livro.getTitulo());
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Livro já foi emprestado! ");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Livro com ID " + id + "não encontrado. ");
    }

    public void devolverLivro(ArrayList<Livro> livros, int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (!livro.getDisponibilidade()) {
                    livro.setDisponibilidade(true);
                    System.out.println();
                    System.out.println("Livro devolvido com sucesso: " + livro.getTitulo());
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("O livro " + livro.getTitulo() + "não está emprestado");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Livro com ID " + id + "não encontrado. ");
        System.out.println();
    }
    public void removerLivro(ArrayList<Livro> livros, int id){
        for (int i = 0; i < livros.size(); i++){
            if (livros.get(i).getId() == id){
                System.out.println();
                System.out.println("livro removido com sucesso: " + livros.get(i). getTitulo());
                System.out.println();
                livros.remove(i);
                return;
            }
        }
        System.out.println();
        System.out.println("Livro com ID " + id + "não encontrado. ");
    }
}
