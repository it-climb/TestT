package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "employees")
public class Employee extends BaseModel{



    @ManyToOne
    @JoinColumn(name="departments_id")
    private Department departments;

    private String firstName;
    private String secondName;



    //---------------------------------------------------------------------------
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



    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department department) {
        this.departments = department;
    }
}
