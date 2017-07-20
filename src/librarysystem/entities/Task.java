package librarysystem.entities;

import java.util.HashSet;
import java.util.Set;

public class Task  implements java.io.Serializable {

    private int id;
    private String name;
    private Set librarians = new HashSet(0);

    public Task() {
    }
	
    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Task(String name) {
       this.name = name;
    }
    
    public Task(int id, String name, Set librarians) {
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

    public Set getLibrarians() {
        return this.librarians;
    }
    
    public void setLibrarians(Set librarians) {
        this.librarians = librarians;
    }

    @Override
    public String toString() {
        return "Task : " + name;
    }

}
