package evg.testt.model;

import javax.persistence.*;

@Entity(name = "admins")
public class Admin extends BaseModel{

    @OneToOne
    @JoinColumn(name="id_person")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
