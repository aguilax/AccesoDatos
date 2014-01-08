package conectarBaseDatos;

import java.sql.*;

/**
 * Clase generica que reune lo necesario para hacer una conexion a una BD mysql
 * a traves de un connector jMysql
 * 
 * @author Paco Aguilar
 * @version 1.0 02/11/2013
 * 
 */
public class ConexionBD {

	private Connection conexion;
	private String bd = "";
	private String user = "";
	private String password = "";
	private String server = "";

	/**
	 * Constructor que crea la conexion
	 * 
	 * @param bd
	 *            ,contiene el nombre de nuestra base de datos
	 * @param user
	 *            ,contiene el nombre de usuario de nuestra base de datos
	 * @param password
	 *            ,contiene el password
	 * @param server
	 *            ,contiene el servidor + la base de datos
	 * 
	 */
	public ConexionBD(String bd, String user, String password, String server) {
		this.bd = bd;
		this.user = user;
		this.password = password;
		this.server = server + bd;

	}

	/**
	 * establece la conexion con el driver JMysql Jdbc
	 */
	public void establecerConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");//hace que sea cargada dinamicamente 
			conexion = DriverManager.getConnection(server, user, password);//intenta establecer una conexion
		} catch (Exception e) {
			System.out.print("No es posible establecer la Conexion"+e);
		}
	}

	/**
	 * Estado de la conexion
	 * 
	 * @return statement ,estado de la conexion,define metodos y propiedades
	 *         para hacer consltas sql
	 */
	public Statement crearStatement() {

		try {
			Statement statement = conexion.createStatement();//Crea un objeto SQLServerStatement para enviar instrucciones SQL a la base de datos.
			return statement;
		} catch (SQLException e) {
			System.out.print("No es posible crear el statement"+e);
		}
		return null;

	}

	/**
	 * devuelve la conexion
	 * 
	 * @return conexion
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Intenta cerrar el recordest,que es el objeto que contiene los datos de la
	 * consulta hecha
	 * 
	 * @param rs,hay que pasarle el recordset que queremos cerrar
	 */
	public void cerrar(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.print("No es posible cerrar el resultSet"+e);
			}
		}
	}

	/**
	 * cierra el statement
	 * 
	 * @param stmt,le pasamos el statement que queremos cerrar
	 *            
	 */
	public void cerrarStmt(java.sql.Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.print("No es posible cerrar el statement"+e);
			}

		}
	}

	/**
	 * Cuando acabamos,cerramos la conexion
	 */
	public void cerrarConn() {

		if (conexion != null) {
			try {
				conexion.close();
			} catch (Exception e) {
				System.out.print("No es posible cerrar la conexion "+e);
			}
		}
	}
}

