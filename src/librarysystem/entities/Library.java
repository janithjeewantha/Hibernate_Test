package librarysystem.entities;

import java.util.HashSet;
import java.util.Set;

public class Library  implements java.io.Serializable {

    private int id;
    private String name;
    private Set<Librarian> librarians = new HashSet<>(0);

    public Library() {
    }

    public Library(int id) {
        this.id = id;
    }

    public Library(String name) {
        this.name = name;
    }
       
    public Library(int id, String name, Set<Librarian> librarians) {
       this.id = id;
       this.name = name;
       this.librarians = librarians;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set<Librarian> getLibrarians() {
        return this.librarians;
    }
    
    public void setLibrarians(Set<Librarian> librarians) {
        this.librarians = librarians;
    }

    @Override
    public String toString() {
        String output = "Library : " + name + "\n";
        output += "Librarians : \n";
        for (Librarian librarian : librarians) {
            output += "  " + librarian.toString() + "\n";
            System.out.println();
        }
        return output;
    }

}


