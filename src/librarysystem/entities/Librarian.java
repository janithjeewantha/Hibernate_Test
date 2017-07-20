package librarysystem.entities;

import java.util.HashSet;
import java.util.Set;

public class Librarian  implements java.io.Serializable {

    private int id;
    private Library library;
    private Role role;
    private String name;
    private Set<Task> tasks = new HashSet<>(0);

    public Librarian() {
    }
	
    public Librarian(int id, Library library, Role role, String name) {
        this.id = id;
        this.library = library;
        this.role = role;
        this.name = name;
    }

    public Librarian(Library library, Role role, String name) {
        this.library = library;
        this.role = role;
        this.name = name;
    }
    
    public Librarian(int id, Library library, Role role, String name, Set<Task> tasks) {
       this.id = id;
       this.library = library;
       this.role = role;
       this.name = name;
       this.tasks = tasks;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Library getLibrary() {
        return this.library;
    }
    
    public void setLibrary(Library library) {
        this.library = library;
    }

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }
    
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        String output = "Librarian : " + name + "\n";
        output += "    Role" + role.toString() + "\n";
        output += "    Tasks : \n";
        for (Task task : tasks) {
            output += "      " + task.toString() + "\n";
        }
        return output;
    }

}
