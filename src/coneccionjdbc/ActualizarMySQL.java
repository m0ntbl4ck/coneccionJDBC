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
public class ActualizarMySQL {
    
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
            String consultaSQL ="UPDATE empleados SET salario = ?, cargo = ? WHERE idEmpleados = 3";
            
                 //Ejecutar la consulta dentro de un PreparedStatement
                PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                
                //Establecer valores para actualizar
                

               
                preparedStatement.setDouble(1, 1328382182831.12312);
                preparedStatement.setString(2, "Desarrollador Senior");
              
                
                 
                   
                   //Ejecutar la actualizacion
                   int filasAfectadas = preparedStatement.executeUpdate();
                   if(filasAfectadas  > 0){
                       System.out.println("Actualizacion exitosa");
                   }else{
                       System.out.println("No se encontraron registos para actualizar");
                   }
            //Cerrar los recursos
            statement.close();
          preparedStatement.close();
            
        }catch(SQLException ex){
            
            System.out.println("Error al actualizar los datos en la DB: "+ex.getMessage());
        }
        
    }
    
}