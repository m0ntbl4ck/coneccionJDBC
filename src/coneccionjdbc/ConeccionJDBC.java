
package coneccionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mont_
 */
public class ConeccionJDBC {
    
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
    static final String USUARIO = "root";
    static final String PASSWORD = "user";
    
    public static void main(String[] args) {
    
        try(Connection conexion = DriverManager.getConnection(JDBC_URL,USUARIO, PASSWORD)){
            //Establecer conexion
            
            System.out.println("Conexión establecida con exito");
        }catch(SQLException ex){
            
            System.out.println("Error al conectar a la base de datos: "+ex.getMessage());
        }
        
    }
    
}
