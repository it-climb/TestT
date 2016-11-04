package evg.testt.model;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "users")
public class User extends BaseModel{

    private String firstName;

    private String secondName;

    @OneToOne
    @JoinColumn(name="id_person")
    private Person person;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}

