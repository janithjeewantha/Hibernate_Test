package librarysystem;

import java.util.List;
import librarysystem.dbaccess.LibraryHandler;
import librarysystem.entities.Librarian;
import librarysystem.entities.Library;
import librarysystem.entities.Role;
import librarysystem.entities.Task;

/**
 *
 * @author janith
 * The demonstration of CRUD operations using the LibraryHandler class
 */
public class LibraryDemo {
    
    LibraryHandler libraryHandler = new LibraryHandler();
    
    public void addLibrary(){        
        System.out.println();
        System.out.println("==== Adding a new library ====");
        Role role = new Role();
        role.setName("Lender");
        Task taskOne = new Task();
        taskOne.setName("Lend Books");
        Task taskTwo = new Task();
        taskTwo.setName("Manage Records");
        Library library = new Library();
        library.setName("University");
        Librarian librarian = new Librarian(library, role, "John");
        librarian.getTasks().add(taskOne);
        librarian.getTasks().add(taskTwo);

        System.out.println("Library Name : " + library.getName());
        System.out.println("Librararian's Name : " + librarian.getName());
        System.out.println("Librararian's Role : " + role.getName());
        System.out.println("Librararian's Tasks : " + taskOne.getName() + " & " + taskTwo.getName());
        
        int index = libraryHandler.addLibrarian(librarian);
        
        System.out.println("   ==== Data inserted ====");
        System.out.println("Library ID : " + index);        
        System.out.println("======== Insert Done. ========");
        System.out.println();
    }
    
    public void getLibraries(){        
        System.out.println("==== Retrieving Libraries ====");
        
        List<Library> libraries = libraryHandler.getLibraries();
        for (Library library : libraries) {
            System.out.println(library);
        }
     
        System.out.println("====== Retrieving Done. ======");
        System.out.println();
    }
}
