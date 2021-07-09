package controller;

import abstracts.dao;
import enums.Cargos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Funcionario;

/*
 * @author Tramontina Cromada
 */

public class daoFuncionario extends dao {
    private Funcionario createObject(ResultSet rs) throws SQLException { 
        return (
            new Funcionario(
                    rs.getInt("ID"),
                    rs.getString("NOME"),
                    Cargos.valueOf(rs.getString("CARGO")),
                    rs.getString("CPF")
            )
        );
    }
    
    public int create(Funcionario funcionario) throws SQLException {
        return super.executeUpdate(
                "INSERT INTO FUNCIONARIO (NOME, CARGO, CPF) VALUES (?,?,?)", 
                funcionario.getNome(),
                funcionario.getCargo().name(),
                funcionario.getCpf()
        );
    }
    
    public Funcionario read(int id) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM FUNCIONARIO WHERE ID = ?", 
                id
        );
        
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Funcionario> read() throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM FUNCIONARIO ORDER BY TIPO"
        );
        
        List<Funcionario> listaFuncionario = new LinkedList<>();
        
        while (rs.next()) {
            listaFuncionario.add(
                    createObject(rs)
            );
        }
        
        return listaFuncionario;
    }
    
    public List<Funcionario> read(String nome) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM FUNCIONARIO WHERE NOME ~ ? ORDER BY NOME",
                nome.toUpperCase()
        );
        
        List<Funcionario> listaFuncionario = new LinkedList<>();
        
        while (rs.next()) {
            listaFuncionario.add(
                    createObject(rs)
            );
        }
        
        return listaFuncionario;
    }
    
    public int update(Funcionario funcionario) throws SQLException {
        return super.executeUpdate(
                "UPDATE FUNCIONARIO SET NOME = ?, CARGO = ?, CPF = ? WHERE ID = ?", 
                funcionario.getNome(),
                funcionario.getCargo().name(),
                funcionario.getCpf(),
                funcionario.getId()
        );
    }
    
    public int delete(Funcionario funcionario) throws SQLException {
        return super.executeUpdate(
                "DELETE FROM FUNCIONARIO WHERE ID = ?", 
                funcionario.getId()
        );
    }
}
