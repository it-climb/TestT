package evg.testt.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.*;

@Entity(name = "roles")
public class Role extends BaseModel{

    private String role;

    private String description;

    Role(){}

    Role(String role, String description){
        this.role = role;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name="id_person")
    private Person person;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
