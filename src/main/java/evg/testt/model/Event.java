package evg.testt.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "events")
public class Event extends BaseModel {

    private String name;

    private String comment;

    private Date date;

    private String type;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    Event(){ }

    Event(String name, String comment, Date date, String type){
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.name = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
