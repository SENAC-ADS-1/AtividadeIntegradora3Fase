package controller;

import abstracts.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;

/*
 * @author Tramontina Cromada
 */

public class daoCliente extends dao {
    private Cliente createObject(ResultSet rs) throws SQLException { 
        return (
            new Cliente(
                    rs.getInt("ID"),
                    rs.getString("NOME"),
                    rs.getString("CPF"),
                    rs.getDate("DATANASCIMENTO").toLocalDate(),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONE")
            )
        );
    }
    
    public int create(Cliente cliente) throws SQLException {
        return super.executeUpdate(
                "INSERT INTO CLIENTE (NOME, CPF, DATANASCIMENTO, EMAIL, TELEFONE) VALUES (?,?,?,?,?)", 
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }
    
    public Cliente read(int id) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CLIENTE WHERE ID = ?", 
                id
        );
        
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Cliente> read() throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CLIENTE ORDER BY NOME"
        );
        
        List<Cliente> listaCliente = new LinkedList<>();
        
        while (rs.next()) {
            listaCliente.add(
                    createObject(rs)
            );
        }
        
        return listaCliente;
    }
    
    public List<Cliente> read(String nome) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CLIENTE WHERE NOME ~ ? ORDER BY NOME",
                nome.toUpperCase()
        );
        
        List<Cliente> listaCliente = new LinkedList<>();
        
        while (rs.next()) {
            listaCliente.add(
                    createObject(rs)
            );
        }
        
        return listaCliente;
    }
    
    public int update(Cliente cliente) throws SQLException {
        return super.executeUpdate(
                "UPDATE CLIENTE SET NOME = ?, CPF = ?, DATANASCIMENTO = ?, EMAIL = ?, TELEFONE = ? WHERE ID = ?", 
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getId()
        );
    }
    
    public int delete(Cliente cliente) throws SQLException {
        return super.executeUpdate(
                "DELETE FROM CLIENTE WHERE ID = ?", 
                cliente.getId()
        );
    }
}
