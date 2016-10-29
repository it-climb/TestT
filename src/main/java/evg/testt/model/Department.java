package evg.testt.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<Employee>();

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
