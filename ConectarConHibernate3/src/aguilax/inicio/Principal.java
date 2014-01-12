package aguilax.inicio;
import aguilax.util.Util;
import aguilax.entidad.Clientes;

import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

public class Principal {

	public static void main(String[] args) {

		Session session;
		session = Util.getSessionFactory().getCurrentSession();
		System.out.println("Begin transaccion");
		session.beginTransaction();
		System.out.println("Despues de Begin transaccion");
		
		Clientes c = new Clientes("payo", "lopez", "23456778", "peru");
		session.save(c);
		session.getTransaction().commit();
		
		session.close();
		
	}

}
