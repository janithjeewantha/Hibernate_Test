/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import librarysystem.dbaccess.LibraryHandler;
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
        //libraryHandler.getLibraries();
        Role role = new Role();
        role.setId(1);
        role.setName("Lender");
        Task task = new Task();
        task.setId(1);
        task.setName("Lend Books");
        Library library = new Library();
        library.setId(2);
        library.setName("University");
        Librarian librarian = new Librarian(1,library, role, "John");
        librarian.getTasks().add(task);

        libraryHandler.addLibrarian(librarian);

    }
    
}
