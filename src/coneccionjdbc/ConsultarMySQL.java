import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mont_
 */
public class ConsultarMySQL {
    
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
            String consultaSQL ="SELECT * FROM empleados";
            
            //Ejecutar la consulta y obtener los datos
              ResultSet resultSet = statement.executeQuery(consultaSQL);
               /* 
                while(resultSet.next()){
                    String nombres = resultSet.getString("nombres");
                    System.out.println("Nombres: "+ nombres);
                }*/
                
     
                while(resultSet.next()){
                    //Obtener datos de cada fila
                     int id = resultSet.getInt("idEmpleados");
                    String nombres = resultSet.getString("nombres");
                    String apellidos = resultSet.getString("apellidos");
                    Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
                    double salario = resultSet.getDouble("salario");
                    String cargo = resultSet.getString("cargo");
                    
                    //Hacemos impresion de los datos
                    System.out.println("ID: "+id+" Nombres: "+ nombres+ " Apellidos: "+ apellidos+
                            " Fecha de Nacimiento: "+ fechaNacimiento+ " Salario: "+salario+ " Cargo: "+ cargo);
                }
                
            //Cerrar los recursos
            statement.close();
            resultSet.close();
            
        }catch(SQLException ex){
            
            System.out.println("Error al leer los datos de la DB: "+ex.getMessage());
        }
        
    }
    
}