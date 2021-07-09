package controller;

import abstracts.dao;
import enums.TipoQuartos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Quarto;

/*
 * @author Tramontina Cromada
 */

public class daoQuarto extends dao {
    private Quarto createObject(ResultSet rs) throws SQLException { 
        return (
            new Quarto(
                    rs.getInt("ID"),
                    TipoQuartos.valueOf(rs.getString("TIPO")),
                    rs.getDouble("VALOR")
            )
        );
    }
    
    public int create(Quarto quarto) throws SQLException {
        return super.executeUpdate(
                "INSERT INTO QUARTO (TIPO, VALOR) VALUES (?,?)", 
                quarto.getTipo().name(),
                quarto.getValor()
        );
    }
    
    public Quarto read(int id) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM QUARTO WHERE ID = ?", 
                id
        );
        
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Quarto> read() throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM QUARTO ORDER BY TIPO"
        );
        
        List<Quarto> listaQuarto = new LinkedList<>();
        
        while (rs.next()) {
            listaQuarto.add(
                    createObject(rs)
            );
        }
        
        return listaQuarto;
    }
    
    public List<Quarto> read(TipoQuartos tipo) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM QUARTO WHERE TIPO = ? ORDER BY TIPO",
                tipo.name()
        );
        
        List<Quarto> listaQuarto = new LinkedList<>();
        
        while (rs.next()) {
            listaQuarto.add(
                    createObject(rs)
            );
        }
        
        return listaQuarto;
    }
    
    public int update(Quarto quarto) throws SQLException {
        return super.executeUpdate(
                "UPDATE QUARTO SET TIPO = ?, VALOR = ? WHERE ID = ?", 
                quarto.getTipo().name(),
                quarto.getValor(),
                quarto.getId()
        );
    }
    
    public int delete(Quarto quarto) throws SQLException {
        return super.executeUpdate(
                "DELETE FROM QUARTO WHERE ID = ?", 
                quarto.getId()
        );
    }
}
