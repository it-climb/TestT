package evg.testt.model;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "employees")


    public class Employee extends BaseModel{

    private String firstName;
    private String secondName;
    @Temporal(value = TemporalType.DATE)
    private Date birthday;




    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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
}
