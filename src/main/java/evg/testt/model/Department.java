package evg.testt.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Employee> employees;
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}