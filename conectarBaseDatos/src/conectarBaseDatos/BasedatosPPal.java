package conectarBaseDatos;
import java.sql.*;
/**
 * Programa que recupera los datos de una bd 
 * @author Francisco Aguilar
 *
 */
public class BasedatosPPal {
	
	//public void f(){	
	public static void main(String[] args) {
	    String bd="clientes";
		String user="admin";
		String password="mypass";
		String server="jdbc:mysql://localhost/";
		ResultSet rs=null;
		ConexionBD c ;//devuelve un objeto conection creado
		
		
		    c=new ConexionBD(bd,user,password,server);//creamos el objeto conexion pasandole los datos al constructor
		    c.establecerConexion();//establecemos la conexion con el driver jdbc
		    Statement st=c.crearStatement();//creamos el statement que sera quien maneje ja consulta
		    
		    try {
		    	 //rs=st.executeQuery("select *from clientes ");// esta es la consulta que le mandamos a la base de datos"
				rs=st.executeQuery("select *from clientes where provincia='Valencia'");// esta es la consulta que le mandamos a la base de datos"
			} catch (SQLException e) {
			System.out.println("la consulta ha fallado"+e);
			}
		   
		   
		
			try {//recuperamos los datos de las COLUMNAS que contiene el resultsetMetadata
				int i=1;
				ResultSetMetaData metaDatos = rs.getMetaData();
				System.out.println(metaDatos.getColumnLabel(i)+"  "+metaDatos.getColumnLabel(i+1)+"  "+metaDatos.getColumnLabel(i+2)+"  "+metaDatos.getColumnLabel(i+3)+"  "+metaDatos.getColumnLabel(i+4));
				System.out.println("----------------------------------------------");
				
				while(rs.next()){
	
				    System.out.println(rs.getString(i)+"     "
				    		+ "   "+rs.getString(i+1)+"  "+rs.getString(i+2)+"  "+rs.getString(i+3)+"  "+rs.getString(i+4));		    
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("no se puede recuperar los datos "+e);
			}
			finally {// cuando acaba el try/catch cerramos el statement y la conexion al abase de datos			
				c.cerrarStmt(st);
				c.cerrarConn();
				c.cerrar(rs);
			}
		}

}
