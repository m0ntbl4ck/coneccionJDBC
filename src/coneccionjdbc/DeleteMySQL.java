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
public class DeleteMySQL {
    
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
            String consultaSQL ="DELETE FROM empleados WHERE idEmpleados = ?";
            
                 //Ejecutar la consulta dentro de un PreparedStatement
                PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                
                //Establecer valores para actualizar
                
                int  empleadoaEliminar = 3;
               
                
                preparedStatement.setDouble(1, empleadoaEliminar);
            

                   //Ejecutar la actualizacion
                   int filasAfectadas = preparedStatement.executeUpdate();
                   if(filasAfectadas  > 0){
                       System.out.println("Eliminacion exitosa");
                   }else{
                       System.out.println("No se encontraron registos para eliminar");
                   }
            //Cerrar los recursos
            statement.close();
          preparedStatement.close();
            
        }catch(SQLException ex){
            
            System.out.println("Error al eliminar los datos en la DB: "+ex.getMessage());
        }
        
    }
    
}