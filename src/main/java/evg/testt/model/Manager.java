package evg.testt.model;

import javax.persistence.*;

@Entity(name = "managers")
public class Manager extends BaseModel{

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
