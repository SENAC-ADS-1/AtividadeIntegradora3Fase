package model;

import java.time.LocalDate;

/*
 * @author Tramontina Cromada
 */

public class Cliente {
    @SwingColumn(description = "Código")
    private int id;
    @SwingColumn(description = "Nome")
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    @SwingColumn(description = "Telefone")
    private String telefone;

    public Cliente() {
        this.setId(0);
        this.setNome("NOME PADRÃO");
        this.setCpf("000.000.000-00");
        this.setDataNascimento(LocalDate.now());
        this.setEmail("email@email.com.br");
        this.setTelefone("(00)00000-0000");
    }

    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public int getId() {
        return this.id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public final void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "NOME PADRÃO" : nome.toUpperCase();
    }

    public String getCpf() {
        return this.cpf;
    }

    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public final void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public final void setEmail(String email) {
        this.email = email.trim().isEmpty() ? "email@email.com.br" : email.toUpperCase();
    }

    public String getTelefone() {
        return this.telefone;
    }

    public final void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.cpf + ", " + this.telefone;
    }
    
    
}
