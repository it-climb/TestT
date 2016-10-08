package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{
    @OneToMany
    List<Employee> employees;

    private String name;



    //~-----------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
