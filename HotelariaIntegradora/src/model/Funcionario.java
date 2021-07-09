package model;

import enums.Cargos;

/*
 * @author Tramontina Cromada
 */

public class Funcionario {
    @SwingColumn(description = "Código")
    private int id;
    @SwingColumn(description = "Nome")
    private String nome;
    @SwingColumn(description = "Cargo")
    private Cargos cargo;
    private String cpf;

    public Funcionario() {
        this.setId(0);
        this.setNome("NOME PADRÃO");
        this.setCargo(Cargos.RC);
        this.setCpf("000.000.000-00");
    }
    
    public Funcionario(int id, String nome, Cargos cargo, String cpf) {
        this.setId(id);
        this.setNome(nome);
        this.setCargo(cargo);
        this.setCpf(cpf);
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

    public Cargos getCargo() {
        return this.cargo;
    }

    public final void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
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
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.cargo;
    }
}
