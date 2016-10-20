package evg.testt.model;

import net.sf.oval.Validator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")

public class Department extends BaseModel{
    @NotNull(message = "it's null", errorCode = "isNull")
    @Length(min=3, max=15, message = "Error length", errorCode = "length")
    @MatchPattern(pattern="[A-Z]{1}[a-z]{14}", message = "Error name, rename", errorCode = "notMuchPattern")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
