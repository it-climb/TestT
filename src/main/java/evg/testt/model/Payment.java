package evg.testt.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "payments")
public class Payment extends BaseModel{

    private Date date;

    private Float payment;

    @ManyToOne
    @JoinColumn(name="id_person")
    private Person person;

    Payment(Date date, Float payment){
        this.date = date;
        this.payment = payment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
