package modelo;




import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionFactory {
    private String URL = "jdbc:mysql://localhost:3306/america_latina_db";
    private String user = "root";
    private String password = "faeavf44";
    
    public Connection getConnection(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection(URL, user, password);
            
        } catch (Exception e) {
            System.out.println("Error Conexion, " + e);
        }
        return conexion;
    }
}
