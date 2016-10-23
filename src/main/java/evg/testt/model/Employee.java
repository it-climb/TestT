package evg.testt.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "employees")
public class Employee extends BaseModel{
    /*
    // -----------------------------------------Отношения в БД----------------------------------------------------
    */
    @ManyToOne
    @JoinColumn(name="departments_id")
    Department departments;
    /*
    // -----------------------------------------------------------------------------------------------------------
    */
    /*
    // -------------------------------------------Переменные------------------------------------------------------
    */
    private String name;
    private String surname;
    private String mail;

    /*
    //------------------------------------------------------------------------------------------------------------
    */
    /*
    // ---------------------------------Сеттеры - Геттеры для переменных------------------------------------------
    */
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getSurname() {

        return surname;
    }
    public void setSurname(String surname) {

        this.surname = surname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    /*
     //------------------------------------------------------------------------------------------------------------
    */
    /*
    // ---------------------------------Сеттеры - Геттеры для departmentBD-----------------------------------------
    */
    public void setDepartments(Department d){
        this.departments = d;
    }
    public Department getDepartments(){
        return departments;
    }
    /*
    // ---------------------------------------------------------------------------------------------------------
    */
}
