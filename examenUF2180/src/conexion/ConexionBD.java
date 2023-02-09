/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author David
 *
 */
public class ConexionBD {

	private static final String database = "empresa";
	private static final String usuario = "Pepe";
	private static final String contrasena = "123";
	private static final String url="jdbc:mysql://localhost/"+database;
	
	private Connection conexion=null;
	
	//2.1  //create user Pepe identified by '123';
	//asigno permisos:
	//grant SELECT,insert,DELETE, UPDATE on empresa.* to Pepe;
	//flush privileges;
	
	
	public Connection getConexion() {
		if (conexion!=null) {
			return conexion;
		}
		
		// REgistra el driver de MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			System.out.println("Conexion a empresa correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no registrado");
		} catch (SQLException e) {
			System.out.println("Error SQLException: "+e.getMessage());
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			System.out.println("Error cerrrando la conexion "+ e.getMessage());
		}
	}

}
