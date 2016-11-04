package evg.testt.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "students")
public class Student extends BaseModel {

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pakage> pakageSet;

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

    public Set<Pakage> getPakageSet() {
        return pakageSet;
    }

    public void setPakageSet(Set<Pakage> pakageSet) {
        this.pakageSet = pakageSet;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}