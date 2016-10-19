package evg.testt.model;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @NotNull(errorCode = "3", message = "Employee's name must be not null")
    @NotBlank(errorCode = "2", message = "Employee's name must be not blank")
    @Length(max = 30, min = 3, errorCode = "1", message = "Employee's first name must have from 3 to 30 chars")
    private String firstName;

    @NotNull(errorCode = "3", message = "Employee's name must be not null")
    @NotBlank(errorCode = "2", message = "Employee's name must be not blank")
    @Length(max = 30, min = 3, errorCode = "1", message = "Employee's second name must have from 3 to 30 chars")
    private String secondName;

    @ManyToOne
    @JoinColumn(name="departments_id")
    private Department departments;

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

    public void setDepartments(Department departments) {
        this.departments = departments;
    }
}

