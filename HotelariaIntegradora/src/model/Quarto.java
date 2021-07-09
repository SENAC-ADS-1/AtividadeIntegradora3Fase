package model;

import enums.TipoQuartos;

/*
 * @author Tramontina Cromada
 */

public class Quarto {
    @SwingColumn(description = "Código")
    private int id;
    @SwingColumn(description = "Tipo")
    private TipoQuartos tipo;
    @SwingColumn(description = "Valor")
    private double valor;

    public Quarto() {
        this.setId(0);
        this.setTipo(TipoQuartos.SO);
        this.setValor(0);
    }

    public Quarto(int id, TipoQuartos tipo, double valor) {
        this.setId(id);
        this.setTipo(tipo);
        this.setValor(valor);
    }

    public int getId() {
        return this.id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public TipoQuartos getTipo() {
        return this.tipo;
    }

    public final void setTipo(TipoQuartos tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public final void setValor(double valor) {
        this.valor = valor < 0 ? 0 : valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Quarto other = (Quarto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.tipo;
    }
}
