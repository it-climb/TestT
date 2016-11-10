package evg.testt.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
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