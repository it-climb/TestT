package evg.testt.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "employees")
public class Employee extends BaseModel{

    private String name;
    private String surname;
    private String patronymic;
    private String birtday;
    private String tel_number;
    private String mail;
    private String department;
    private String position;
    private String date_of_registration;
    private String current_project;

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(String birtday) {
        this.date_of_registration = date_of_registration;
    }

    public String getCurrent_project() {
        return current_project;
    }

    public void setCurrent_project(String current_project) {
        this.current_project = current_project;
    }
}
