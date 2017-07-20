package librarysystem.dbaccess;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import librarysystem.dbconnector.DBConnector;
import librarysystem.entities.Library;
import librarysystem.entities.Librarian;
import librarysystem.entities.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author janith
 */
public class LibraryHandler {

    Transaction tx = null;
    SessionFactory factory = DBConnector.getSessionFactory();
    Session session;

    public List<Library> getLibraries() {

        List<Library> libraries = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            libraries = session.createQuery("FROM Library").list();
            tx.commit();
            session.close();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                    System.out.println("Error occured! Transaction rolled back");
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                e.printStackTrace();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return libraries;
    }

    public int addLibrary(Library library) {
        
        Integer id = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            id = (Integer) session.save(library);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return id;
    }

    public int addLibrarian(Librarian librarian) {
        Integer id = -1;
        int libraryId = -1;
        int roleId = -1;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            id = (Integer) session.save(librarian);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return id;
    }
}
