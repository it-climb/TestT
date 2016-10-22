package evg.testt.model;

import net.sf.oval.constraint.MatchPattern;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Calendar;


@Entity(name = "employees")
public class Employee extends BaseModel{

    private String firstName;
    private String secondName;
    private String phone;

    @MatchPattern(pattern = "^([a-z0-9]{1,}[\\.\\_\\-]?[a-z0-9]{1,})\\@([a-z0-9]{2,}\\.)([a-z]{2,2}|com|ru|ua)$", message = "Error e-mail!!! Try again")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateOfBirth;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge(){
        int age = 0;
        Calendar curentDate = Calendar.getInstance();
        age = curentDate.getTime().getYear() - dateOfBirth.getTime().getYear();

        return age;
    }
}

