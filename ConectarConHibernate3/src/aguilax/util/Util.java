package aguilax.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase que se ocupa de crear,configurar  y devolver la sesion
 * @author Paco
 *
 */

public class Util {
    private static final SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
        	System.out.println("Conexion fallida  " +ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Devuelve la sesion
     * @return 
     */
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
				