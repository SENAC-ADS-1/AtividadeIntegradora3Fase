package controller;

import abstracts.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import model.Quarto;
import model.Reserva;

/*
 * @author Tramontina Cromada
 */

public class daoReserva extends dao {
    private Reserva createObject(ResultSet rs) throws SQLException { 
        return (
            new Reserva(
                    rs.getInt("ID"),
                    new daoFuncionario().read(rs.getInt("ID_FUNCIONARIO")),
                    new daoCliente().read(rs.getInt("ID_CLIENTE")),
                    new daoQuarto().read(rs.getInt("ID_QUARTO")),
                    rs.getDouble("VALOR"),
                    rs.getDate("DATA").toLocalDate()
            )
        );
    }
    
    public int create(Reserva reserva) throws SQLException {
        return super.executeUpdate(
                "INSERT INTO RESERVA (ID_FUNCIONARIO, ID_CLIENTE, ID_QUARTO, VALOR, DATA) VALUES (?,?,?,?,?)", 
                reserva.getFuncionario().getId(),
                reserva.getCliente().getId(),
                reserva.getQuarto().getId(),
                reserva.getValor(),
                reserva.getData()
        );
    }
    
    public Reserva read(int id) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM RESERVA WHERE ID = ?", 
                id
        );
        
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Reserva> read() throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM RESERVA ORDER BY ID"
        );
        
        List<Reserva> listaReserva = new LinkedList<>();
        
        while (rs.next()) {
            listaReserva.add(
                    createObject(rs)
            );
        }
        
        return listaReserva;
    }
    
    public List<Reserva> read(Quarto quarto) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM RESERVA WHERE ID_QUARTO = ? ORDER BY ID",
                quarto.getId()
        );
        
        List<Reserva> listaReserva = new LinkedList<>();
        
        while (rs.next()) {
            listaReserva.add(
                    createObject(rs)
            );
        }
        
        return listaReserva;
    }
    
    public List<Reserva> read(LocalDate data) throws SQLException{
        ResultSet rs = super.executeQuery(
                "SELECT * FROM RESERVA WHERE DATA = ? ORDER BY ID",
                data
        );
        
        List<Reserva> listaReserva = new LinkedList<>();
        
        while (rs.next()) {
            listaReserva.add(
                    createObject(rs)
            );
        }
        
        return listaReserva;
    }
    
    public int update(Reserva reserva) throws SQLException {
        return super.executeUpdate(
                "UPDATE RESERVA SET ID_FUNCIONARIO = ?, ID_CLIENTE = ?, ID_QUARTO = ?, VALOR = ?, DATA = ? WHERE ID = ?", 
                reserva.getFuncionario().getId(),
                reserva.getCliente().getId(),
                reserva.getQuarto().getId(),
                reserva.getValor(),
                reserva.getData(),
                reserva.getId()
        );
    }
    
    public int delete(Reserva reserva) throws SQLException {
        return super.executeUpdate(
                "DELETE FROM RESERVA WHERE ID = ?", 
                reserva.getId()
        );
    }
}
