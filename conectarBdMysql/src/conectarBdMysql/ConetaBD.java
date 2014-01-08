package conectarBdMysql;
import java.sql.*;
public class ConetaBD {
	private Connection conexion;
	private String user;
	private String password;
	private String server;
	private String bd;
	
	
	public void ConectaBD(String user,String password,String server,String bd) {
		this.server=server;
		this.user=user;
		this.password =password;
		this.bd=bd;
	}
	
	public void establecerConexionBD(){
		try {
			Class.forName("com.mysql.jdbc.Driver");// se intenta cargar el driver
		} catch (ClassNotFoundException e) {
			System.out.println("no se ha encontrado el Driver"+e);
		}
		try {
			conexion=DriverManager.getConnection(server+bd, user, password);
		} catch (SQLException e) {
			System.out.println("no se ha encontrado el Driver"+e);
			System.out.println("no se ha podido conectar con la base de datos"+e);
		}
	
	}
	public Statement getStatement(){
		
		try {
			Statement st = conexion.createStatement();
			return st;									//devuelve el statement que contendra las consultas sql
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;									//si no lo consigue develve null
	} 
	
	public void cerrarStatement(Statement st){
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("no se ha podido cerrar el statement"+e);
		}
		
	}
	public void cerrarResulset(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			
			System.out.println("no se ha podido cerrar el statement"+e);
		}
	}
	public void cerrarConexion(Connection c){
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("no se ha podido cerrar la conexion"+e);
		}
		
	}
}
