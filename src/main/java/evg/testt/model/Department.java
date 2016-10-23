package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel {
    /*
    // -----------------------------------------Отношения в БД----------------------------------------------------
    */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL)
    List<Employee> employee;
    /*
    // -----------------------------------------------------------------------------------------------------------
    */

    /*
    // -------------------------------------------Переменные------------------------------------------------------
    */
    private String name;
    private String tel;
    private int numbersOfEmployeer;
    private String mail;
    private String nameOfEmployeer;
    /*
    // ----------------------------------------------------------------------------------------------------------
    */
    /*
    // ---------------------------------Сеттеры - Геттеры для переменных-----------------------------------------
    */
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

    /*
    // ---------------------------------------------------------------------------------------------------------
    */
    /*
    // ---------------------------------Сеттеры - Геттеры для эмплоеров-----------------------------------------
    */
    public void setListEmpl(List<Employee> e){
        this.employee = e;
    }
    public List<Employee> getListEmpl(){
        return employee;
    }
    /*
    // ---------------------------------------------------------------------------------------------------------
    */

}
