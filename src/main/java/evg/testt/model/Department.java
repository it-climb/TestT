package evg.testt.model;

import javax.persistence.*;
import javax.annotation.*;
import java.util.Set;


@Entity(name = "departments")


public class Department extends BaseModel{


    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.REMOVE)
    private Set<Employee> employees;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
