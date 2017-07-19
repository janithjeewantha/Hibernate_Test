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
        role.setName("Lender");
        Task task = new Task();
        task.setName("Lend Books");
        Library library = new Library();
        library.setName("University");
        Librarian librarian = new Librarian(library, role, "John");
        
        libraryHandler.addLibrary(library);
        
    }
    
}
