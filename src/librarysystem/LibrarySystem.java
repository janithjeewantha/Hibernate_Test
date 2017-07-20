/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.List;
import librarysystem.dbaccess.LibraryHandler;
import librarysystem.dbconnector.DBConnector;
import librarysystem.entities.Librarian;
import librarysystem.entities.Library;
import librarysystem.entities.Role;
import librarysystem.entities.Task;

/**
 *
 * @author janith
 */
public class LibrarySystem {

    public static void main(String[] args) {

        LibraryHandler libraryHandler = new LibraryHandler();
        
        List<Library> libraries = libraryHandler.getLibraries();
        for (Library library : libraries) {
            System.out.println(library);
        }
        
        
//        Role role = new Role();
//        role.setName("Lenderaa");
//        Task task = new Task();
//        task.setName("Lend Booksaa");
//        Library library = new Library();
//        library.setName("Universityaa");
//        Librarian librarian = new Librarian(library, role, "Johnaa");
//        librarian.getTasks().add(task);
//
//        int index = libraryHandler.addLibrarian(librarian);
//        System.out.println(index);
        
        DBConnector.close();
    }
    
}
