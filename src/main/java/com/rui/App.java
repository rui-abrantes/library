package main.java.com.rui;

import java.util.Scanner;

import main.java.com.rui.models.Biblioteca;
import main.java.com.rui.models.Livro;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    
        Biblioteca biblioteca = new Biblioteca();
        
    
        while(true){
            System.out.println("Deseja ver os livros disponíveis ?");

            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao"))
                break;
            if(!resposta.equalsIgnoreCase("sim"))
                continue;
        
            System.out.println("Esta é a lista de livros disponíveis: ");
            
            biblioteca.getLivros().forEach(livro -> {
                if(livro.isDisponivel()) 
                    System.out.println("ID: " + livro.getId() + " - " + livro.getTitulo());
            });

            System.out.println("Qual livro quer para empréstimo ? ");

            String livroIdAsString = scanner.nextLine();

            Integer livroId = Integer.valueOf(livroIdAsString);

            Livro livroParEmprestimo = biblioteca.getLivroById(livroId);

            System.out.println("O livro " + livroParEmprestimo.getTitulo() + " vai ser emprestado");

            System.out.println("Qual o seu nome ?");

            String nome = scanner.nextLine();

            biblioteca.addEmprestimo(livroId, nome);
        }
        System.out.println("Obrigado e volte sempre.");
    }
}
