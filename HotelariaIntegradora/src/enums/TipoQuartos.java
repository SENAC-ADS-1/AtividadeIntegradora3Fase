package enums;

/*
 * @author Tramontina Cromada
 */

public enum TipoQuartos {
    SU("SUÍTE"),
    CS("CASAL"),
    SO("SOLTEIRO");
    
    private final String descricao;
    
    private TipoQuartos(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
