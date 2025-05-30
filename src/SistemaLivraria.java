import java.time.LocalDate;
import java.util.*;

class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(int id, String nome, LocalDate dataNascimento) {
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

    public Livro(int id, String titulo, Autor autor) {
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
        this.dataAtualizacao = LocalDate.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor.getNome();
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

    public Biblioteca() {
        Autor autor1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        autores.add(autor1);
        autores.add(autor2);

        livros.add(new Livro(1, "Dom Casmurro", autor1));
        livros.add(new Livro(2, "A Hora da Estrela", autor2));
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id && livro.isDisponivel()) {
                return livro;
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
            System.out.print("Deseja ver os livros disponíveis? (sim/não): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("sim")) {
                biblioteca.listarLivrosDisponiveis();

                System.out.print("Digite o ID do livro que deseja emprestar: ");
                int idLivro = Integer.parseInt(scanner.nextLine());

                Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                if (livroSelecionado != null) {
                    System.out.print("Digite seu nome: ");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.registrarEmprestimo(nomeUsuario, livroSelecionado);
                } else {
                    System.out.println("Livro não disponível ou não encontrado.");
                }

            } else if (resposta.equals("não")) {
                System.out.println("Encerrando a aplicação. Obrigado por usar o sistema da biblioteca.");
                break;
            } else {
                System.out.println("Resposta inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

