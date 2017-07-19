package librarysystem.dbaccess;

import java.util.Iterator;
import java.util.List;
import librarysystem.dbconnector.DBConnector;
import librarysystem.entities.Library;
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

            for (Iterator iter = libraries.iterator(); iter.hasNext();) {
                Library element = (Library) iter.next();
                System.out.println(element);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        } finally {
            factory.getCurrentSession().close();
        }

        return libraries;
    }

    public int addLibrary(Library library) {
        Session session;
        Transaction tx = null;
        Integer id = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            id = (Integer) session.save(library);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.getCurrentSession().close();
        }
        return id;
    }

}
