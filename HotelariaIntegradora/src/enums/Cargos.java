package enums;

/*
 * @author Tramontina Cromada
 */

public enum Cargos {
    GR("GERENTE"),
    RC("RECEPCIONISTA"),
    CM("CAMAREIRO(A)");
    
    private final String descricao;
    
    private Cargos(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
