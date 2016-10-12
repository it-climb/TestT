package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@Entity(name = "departments")
public class Department extends BaseModel {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;


//    @NotNull
//    @Size(min = 3, max = 7, message = "Department name length must be more than three symbols")
    private String name;



    //-----------------------------------------------------------------------------------------
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





//    private static Validator validator;
//
//
//    public static void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    public void nameTooShort() {
//        Department department = new Department();
//
//        Set<ConstraintViolation<Department>> constraintViolations =
//                validator.validate( department );
//
//    }




//    @Override
//    public String toString() {
//        return String.format("name: [%s]", name);
//
//    }

//
//    public static void validate(Object object, Validator validator) {
//        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
//
//        System.out.println(object);
//        System.out.println(String.format("Кол-во ошибок: %d",
//                constraintViolations.size()));

//        for (ConstraintViolation<Object> cv : constraintViolations)
//            System.out.println(String.format(
//                    "Внимание, ошибка! property: [%s], value: [%s], message: [%s]",
//                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
//    }




}






























//package evg.testt.model;
//
//        import javax.persistence.CascadeType;
//        import javax.persistence.Entity;
//        import javax.persistence.FetchType;
//        import javax.persistence.OneToMany;
//        import java.util.List;
//
//@Entity(name = "departments")
//public class Department extends BaseModel{
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Employee> employees;
//    private String name;
//
//
//    //-----------------------------------------------------------------------------------------
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//}


