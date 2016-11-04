package evg.testt.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher extends BaseModel{

    @OneToOne
    @JoinColumn(name="id_person")
    private Person person;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groupSet;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

}
