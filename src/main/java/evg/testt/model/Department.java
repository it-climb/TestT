package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    @OneToMany
    private List<Employee> DepEmployee = new ArrayList<>();

    public List<Employee> getDepEmployee() {
        return DepEmployee;
    }

    public void setDepEmployee(List<Employee> depEmployee) {
        DepEmployee = depEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
