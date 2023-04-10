package dictionnaire;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ConnectionBDD {
    
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/word";
        String username = "root";
        String password = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "start ur Server");
            System.exit(-1);
        }
        return connection;
        
    }
}
