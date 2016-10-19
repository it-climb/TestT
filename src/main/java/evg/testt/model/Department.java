package evg.testt.model;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Employee> employeeList;

    @NotNull(errorCode = "3", message = "Department's name must be not null")
    @NotBlank(errorCode = "2", message = "Department's name must be not blank")
    @Length(max = 30, min = 3, errorCode = "1", message = "Department's name must have from 3 to 30 chars")
    private String name;

    @NotNull
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
