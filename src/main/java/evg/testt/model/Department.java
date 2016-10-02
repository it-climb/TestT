package evg.testt.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;
    private String tel;
    private int numbersOfEmployeer;
    private String mail;
    private String nameOfEmployeer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getNumbersOfEmployeer() {
        return numbersOfEmployeer;
    }

    public void setNumbersOfEmployeer(int numbersOfEmployeer) {
        this.numbersOfEmployeer = numbersOfEmployeer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNameOfEmployeer() {
        return nameOfEmployeer;
    }

    public void setNameOfEmployeer(String nameOfEmployeer) {
        this.nameOfEmployeer = nameOfEmployeer;
    }
}
