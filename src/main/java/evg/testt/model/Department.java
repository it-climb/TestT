package evg.testt.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "department")
    private List<Employee> depEmployee;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public List<Employee> getDepEmployee() {
        return depEmployee;
    }

    public void setDepEmployee(List<Employee> depEmployee) {
        this.depEmployee = depEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
