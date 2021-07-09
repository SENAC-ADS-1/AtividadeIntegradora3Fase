package model;

import java.time.LocalDate;

/*
 * @author Tramontina Cromada
 */

public class Reserva {
    @SwingColumn(description = "Código")
    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    @SwingColumn(description = "Quarto")
    private Quarto quarto;
    private double valor;
    @SwingColumn(description = "Data")
    private LocalDate data;

    public Reserva() {
        this.setId(0);
        this.setFuncionario(null);
        this.setCliente(null);
        this.setQuarto(null);
        this.setValor(0);
        this.setData(LocalDate.now());
    }

    public Reserva(int id, Funcionario funcionario, Cliente cliente, Quarto quarto, double valor, LocalDate data) {
        this.setId(id);
        this.setFuncionario(funcionario);
        this.setCliente(cliente);
        this.setQuarto(quarto);
        this.setValor(valor);
        this.setData(data);
    }

    public int getId() {
        return this.id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public final void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public final void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return this.quarto;
    }

    public final void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public double getValor() {
        return this.valor;
    }

    public final void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return this.data;
    }

    public final void setData(LocalDate data) {
        this.data = data;
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
        final Reserva other = (Reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.cliente + ", " + this.quarto + ", " + this.valor;
    }
}
