package aguilax.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import aguilax.entidad.Persona;

/**
 * Clase que contiene los metodos necesarios para crear un registro,listar una
 * tabla actualizar registros y borrar un registro.
 * 
 * @author Paco
 * @version 31/01/2014
 */
public class MetodosDAO {

	public MetodosDAO() {

	}

	/**
	 * Metodo que se encarga de crear un registro en la base de datos
	 * el id sera autoincrmental,puesto en Persona.hbm.xml->dentro del punto  increment
	 * por eso para crearlo le damos un id =0.
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	public void addRegistro(String nombre, String apellidos, String dni) {
		
		Session ss = Util.getSessionFactory().openSession();
		Transaction tr = null;
		try {
			tr = ss.beginTransaction();// comenzamos a hacer cositas
			// id incremental,por eso pongo cero
			Persona p = new Persona(0, nombre, apellidos, dni);
			ss.save(p);
			tr.commit();
		} catch (HibernateException e) {
			System.out.println("Pako_error=  " + e);
		} finally {
			ss.close();
			// System.out.println("Final");
		}
	}

	/**
	 * Se encarga de mostrar los datos de la tabla ,dandole formato. los datos
	 * se obtienen de una list que contendra todos los objetos Persona
	 */
	public void verTabla() {
		Session ss = Util.getSessionFactory().openSession();
		Transaction tr = null;
		try {
			tr = ss.beginTransaction();
			List<Persona> p = ss.createQuery("from Persona").list();
			System.out.println("id  nombre   apellidos   Dni");
			for (Persona p2 : p) {

				System.out.println("-----------------------------");
				System.out.println(p2.getId() + "    " + p2.getNombre() + "   "
						+ p2.getApellidos() + "   " + p2.getDni());
			}
			System.out.println("**********************************");
			tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}

	}

	/**
	 * Se actualiza cualaluier registro a traves de su id,se obtiene lel objeto
	 * deseado obteniedolo de la sesion activa con get(Persona.class,id),una vez
	 * tenemos el objeto solo hay que modificar sus campos.Si se recibe algun
	 * parametro vacio no se actualizara ese campo si el id no existe dará un
	 * error.
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param dni
	 */
	public void updateRegisto(int id, String nombre, String apellido, String dni) {
		Session ss = Util.getSessionFactory().openSession();
		Transaction tr = null;

		try {
			tr = ss.beginTransaction();
			Persona p = (Persona) ss.get(Persona.class, id);
			if (p != null) {
				System.out.println("id= " + id);
				if (!nombre.equals("")) {
					p.setNombre(nombre);
				}
				if (!apellido.equals("")) {
					p.setApellidos(apellido);
				}
				if (!dni.equals("")) {
					p.setDni(dni);
				}
				tr.commit();
			} else {
				System.out.println("No existe ese registro");
			}
		} catch (HibernateException e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}

	}

	/**
	 * Borra un registro a partir del id que se le pasa usando session.delete(obj)
	 * antes de ser borrado se comprueba que no sea null que querra decir que el 
	 * objeto existe y que el id es correcto,tambien se pide confirmacion antes de borrar
	 * @param id
	 */
	public void borrarRegistro(int id) {
		Session ss = Util.getSessionFactory().openSession();
		Transaction tr = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			tr = ss.beginTransaction();
			Persona p = (Persona) ss.get(Persona.class, id);
			if (p != null) {
				System.out.println("Va a borrar " + p.getId() + " "
						+ p.getNombre() + " " + p.getApellidos() + " "
						+ p.getDni());
				System.out.println("Está seguro si/no");
				String respuesta = br.readLine();
				if (respuesta.equals("si")) {
					ss.delete(p);
					tr.commit();
					System.out.println("Registro borrado satisfactoriamente");
				} else {
					System.out.println("No se ha borrado nada");
				}
			} else {
				System.out.println("No existe ese registro");
			}
		} catch (HibernateException e) {
			tr.rollback();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
	}
}