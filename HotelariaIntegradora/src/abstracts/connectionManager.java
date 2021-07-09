package abstracts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author Tramontina Cromada
 */

abstract public class connectionManager {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Integradora",
                    "postgres",
                    "postgres"
            );
        }
        
        return connection;
    }
}
