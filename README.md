# 📚 Sistema de Empréstimo de Livros - Biblioteca Java

Um sistema simples de gerenciamento de biblioteca em Java, com foco em **listagem de livros disponíveis** e **empréstimo de livros**. Ideal para fins educacionais e projetos introdutórios de orientação a objetos.

---

## ✨ Funcionalidades

- 📖 **Listagem de livros disponíveis**
- 👤 **Empréstimo de livros com nome do usuário**
- ✅ Atualização do status de disponibilidade após o empréstimo
- 🕹️ Loop de interação com o usuário via console

---

## 🧩 Estrutura do Projeto

O projeto é dividido em classes principais:

### 📘 `Livro`
- `id`: Identificador único
- `titulo`: Título do livro
- `autor`: Objeto do tipo `Autor`
- `disponivel`: Disponibilidade para empréstimo
- `dataCadastro` e `dataAtualizacao`: Datas importantes do livro

### 🧑‍🏫 `Autor`
- `id`: Identificador único
- `nome`: Nome do autor
- `dataNascimento`: Data de nascimento

### 🏛️ `Biblioteca`
- `livros`: Lista de livros cadastrados
- `autores`: Lista de autores
- `emprestimos`: Lista de registros de empréstimos

### 📅 `Emprestimo` *(opcional para registrar cada empréstimo)*
- `livro`: Livro emprestado
- `nomeUsuario`: Nome de quem pegou o livro
- `dataEmprestimo`: Data do empréstimo

---

## 🚀 Como Executar

> Requisitos: Java 17+ e IntelliJ IDEA (ou outro IDE)

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/biblioteca-java.git

