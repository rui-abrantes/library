package main.java.com.rui.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros;
    private List<Autor> autores;
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public Biblioteca() {

        this.autores = List.of(
            new Autor(
                1,
                "José Saramago",
                LocalDate.of(1922, 11, 16)
            ),
            new Autor(
                2,
                "Fernando Pessoa",
                LocalDate.of(1888, 6, 13)
            )
        );

        this.livros = List.of(
            new Livro(
                1,
                "Ensaio sobre a Cegueira",
                "José Saramago",
                true,
                LocalDate.of(2026, 1, 10),
                LocalDate.of(2026, 1, 10)
            ),
            new Livro(
                2,
                "O Livro do Desassossego",
                "Fernando Pessoa",
                false,
                LocalDate.of(2026, 2, 15),
                LocalDate.of(2026, 3, 1)
            ),
            new Livro(
                3,
                "Memorial do Convento",
                "José Saramago",
                true,
                LocalDate.of(2026, 3, 5),
                LocalDate.of(2026, 3, 5)
            )
        );
    }

    public Livro getLivroById(Integer livroId) {
        for (Livro livro : livros) {
            if (livro.getId().equals(livroId)) {
                return livro;
            }
        }

        return null;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void addEmprestimo(Integer livroId){
        Livro livro = getLivroById(livroId);

        livro.setDisponivel(false);

        emprestimos.add(new Emprestimo(emprestimos.size(), livro, "Rui", LocalDate.now(), LocalDate.now().plusDays(7)));
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}