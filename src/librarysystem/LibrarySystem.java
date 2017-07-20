package librarysystem;

import librarysystem.dbconnector.DBConnector;

/**
 *
 * @author janith
 */
public class LibrarySystem {

    public static void main(String[] args) {

        LibraryDemo demo = new LibraryDemo();
        
        demo.addLibrary();
        demo.getLibraries();
        
        DBConnector.close();
    }
    
}
