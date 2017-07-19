/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem.dbconnector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author janith
 */
public class DBConnector {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed.\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    
    public static Session getCurrentSession() {
        SESSION_FACTORY.openSession();
        System.out.println(SESSION_FACTORY);
        return SESSION_FACTORY.getCurrentSession();
    }

    public static void close(){
        if (SESSION_FACTORY != null)
            SESSION_FACTORY.close();
    }
    
}
