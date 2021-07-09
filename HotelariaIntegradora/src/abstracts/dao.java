package abstracts;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/*
 * @author Tramontina Cromada
 */

abstract public class dao {
    public PreparedStatement getStatement(String SQL) throws SQLException {
        return connectionManager.getConnection().prepareStatement(SQL);
    };
    
    public int executeUpdate(String SQL, Object ... args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(SQL);
        
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i+1, args[i]);
        }
        
        return preparedStatement.executeUpdate();
    }
    
    public ResultSet executeQuery(String SQL, Object ... args) throws SQLException {
        PreparedStatement preparedStatement = getStatement(SQL);
        
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i+1, args[i]);
        }
        
        return preparedStatement.executeQuery();
    }
}
