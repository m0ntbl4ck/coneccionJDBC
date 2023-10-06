
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import static java.util.Calendar.*;

/**
 *
 * @author mont_
 */
public class GuardarMySQL {
    
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/empresa";
    static final String USUARIO = "root";
    static final String PASSWORD = "user";
    
    public static void main(String[] args) {
    
        try(Connection conexion = DriverManager.getConnection(JDBC_URL,USUARIO, PASSWORD)
          ){
            //Establecer conexion
            
            System.out.println("Conexión establecida con exito");
            
            //Crear un objeto Statement para ejecutar consultas
            Statement statement = conexion.createStatement();
            
            //Crear el Query o Consultas que deseamos ejecutar
            String consultaSQL ="INSERT INTO empleados (idEmpleados, nombres, apellidos, fechaNacimiento, salario, cargo)"
                    + "VALUES (?, ?, ?, ?, ?, ? )";
            
                 //Ejecutar la consulta dentro de un PreparedStatement
                PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                
                //Establecer valores para agregar
                
                Date fechaDate = Date.valueOf(LocalDate.of(1996, JULY, 17));
               
                preparedStatement.setInt(1, 5);
                preparedStatement.setString(2, "Juan Andres");
                preparedStatement.setString(3, "Garzon Ortiz"); 
                 preparedStatement.setDate(4,fechaDate); 
                  preparedStatement.setDouble(5, 123231.1); 
                   preparedStatement.setString(6, "Product Owner"); 
                   
                   //Ejecutar la insersion
                   int filasAfectadas = preparedStatement.executeUpdate();
                   if(filasAfectadas  > 0){
                       System.out.println("Registros insertados con exito");
                   }else{
                       System.out.println("No se pudieron insertar los registros");
                   }
            //Cerrar los recursos
            statement.close();
          preparedStatement.close();
            
        }catch(SQLException ex){
            
            System.out.println("Error al insertar los datos en la DB: "+ex.getMessage());
        }
        
    }
    
}