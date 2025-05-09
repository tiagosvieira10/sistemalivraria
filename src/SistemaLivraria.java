import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor (int id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }
}

class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro (int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Titulo: " + titulo + " | Autor " + autor.getNome();
    }
}

class Emprestimo {
    private String nomeUsuario;
    private Livro livro;
    private LocalDate dataEmprestimo;

    public Emprestimo(String nomeUsuario, Livro livro) {
        this.nomeUsuario = nomeUsuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
    }
}

class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca () {
        Autor autor1 = new Autor(1, "Tiago Cavaco", LocalDate.of(1978, 9, 21));
        Autor autor2 = new Autor(2, "Yago Martins", LocalDate.of(1982, 6, 18));
        autores.add(autor1);
        autores.add(autor2);

        livros.add(new Livro(1, "Os três nãos de Deus", autor1));
        livros.add(new Livro(2, "Você é o ponto fraco de Deus", autor2));
    }

    public void ListarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
        return null;
    }

    public void registrarEmprestimo(String nomeUsuario, Livro livro) {
        livro.emprestar();
        emprestimos.add(new Emprestimo(nomeUsuario, livro));
        System.out.println("Livro \"" + livro.getTitulo() + "\" emprestado com sucesso para " + nomeUsuario + ".");
    }
}

public class SistemaLivraria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (sim/não): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if(resposta.equals("sim")) {
                biblioteca.listarLivrosDisponiveis();

                System.out.println("Digite o ID do livros que deseja emprestar: ");
                int idLivro = Integer.parseInt(scanner.nextLine());

                Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                if (livroSelecionado != null) {
                    System.out.println("Digite seu nome: ");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.registrarEmprestimo(nomeUsuario, livroSelecionado);
                }else {
                    System.out.println("Livro não disponível ou não encontrado.");
                }
            } else if (resposta.equals("não")) {
                System.out.println("Encerrando a aplicação. Obrigado por usar o sistema da biblioteca");
                break;
            } else {
                System.out.println("Resposta inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
