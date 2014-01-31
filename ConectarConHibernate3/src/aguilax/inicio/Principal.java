package aguilax.inicio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import aguilax.util.MetodosDAO;
public class Principal {
	
	
    public static void main(String[] args) {
	int salida=0;	
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader (isr);
	crearMenu();
	while (salida!=5){
	  
		try {
			 salida= Integer.parseInt(br.readLine().toString());
			 switch (salida) {
			 case 1:crearRegistro();
			 		crearMenu();
			 break; 
			 
			 case 2:verTabla();
			 		crearMenu();
			 break; 
			 
			 case 3:updateRegisto();
			 		crearMenu();
		 	 break; 
		 	 
			 case 4:borrarRegistro();
			 		crearMenu();
		 	 break;
			 case 5:
		 		System.out.println("Fin del programa");
		     break;
		     }	
		} 
		catch (IOException e) {
			 e.printStackTrace();
		}
     }		
     }
	
	/**
	 * Genera un menu 
	 */
	public static void crearMenu(){
		System.out.println("+++++++++++++++++++++++");
		System.out.println("| 1.- Crear registro  |");
		System.out.println("| 2.- Ver tabla       |");
		System.out.println("| 3.- actualizar      |");
		System.out.println("| 4.- Borrar registro |");
		System.out.println("| 5.- salir           |") ;
		System.out.println("+++++++++++++++++++++++");
	}
	/**
	 * Pide los datos necesarios para crear un registro nuevo,luego llama al metodo
	 * addRegistro de la clase MetodossDAO que hace todo el ttrabajo.
	 */
	public static void crearRegistro(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		MetodosDAO metodos=new MetodosDAO();
		try {
			System.out.println("Inturoduce el nombre ");
			String nombre= br.readLine();
			System.out.println("Inturoduce el Apellido ");
			String apellidos= br.readLine();
			System.out.println("Inturoduce el Dni ");
			String dni= br.readLine();
			metodos.addRegistro( nombre, apellidos, dni);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Hace una llamada a metodos.verTabla que hace un listado de la tabla 
	 */
	public static void verTabla(){
	MetodosDAO metodos=new MetodosDAO();
	metodos.verTabla();
	}
	
	/**
	 * Pide los datos necesarios para actualizar un registro,luego llama al metodo
	 * updateRegistro que hace las comprobaciones previas y actualiza solo los campos que
	 * contiene datos
	 */
	public static void updateRegisto(){
		MetodosDAO metodos=new MetodosDAO();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		try {
			System.out.println("Intdroduce el id del registro que quieres actualizar");
			System.out.println("debes introducir solo los campos a modificar");
			System.out.println("si no lo quieres modificar aprieta ENTER");

			
			String id= br.readLine();			
			System.out.println("Intdroduce el nuevo nombre ");
			String nombre= br.readLine();
			System.out.println("Intdroduce el nuevo Apellido ");
			String apellidos= br.readLine();
			System.out.println("Intdroduce el nuevo Dni ");
			String dni= br.readLine();
			metodos.updateRegisto( Integer.parseInt(id),nombre, apellidos, dni);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Llama al metodo borrarRegistro que se ocupa de la comprobacion del id y el borrado
	 * si procede,tambien pedira confirmacion
	 */
	public static void borrarRegistro(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		MetodosDAO metodos=new MetodosDAO();
		System.out.println("Intdroduce el id del registro a borrar ");
		
		try {
			String id = br.readLine();
			metodos.borrarRegistro( Integer.parseInt(id));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
