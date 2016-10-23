package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployyerService;
import evg.testt.service.ValidationService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployyerService employyerService;

    ValidationService validation = new ValidationService();

    /*
    // ---------------------------------------------Вывод отделов------------------------------------------------
    */
    @RequestMapping(value = "/depOutPut", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        ModelAndView mav = new ModelAndView(JspPath.DEPARTMENT_MAIN);

        try {
            departments = departmentService.getAll();

        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }

        mav.addObject("departments", departments);
        return mav;
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ----------------------------------------Запуск страницы отделов-------------------------------------------
    */
    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ----------------------------------------Сохранение значение отделов---------------------------------------
    */
    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, String mail, String tel) {

        Department addedDepartment = new Department();

        if(validation.getNameMatch(name)){
            addedDepartment.setName(name);
        }
        else{
            return "redirect:/depAdd";
        }

        if(validation.getEmailMatch(mail)){
            addedDepartment.setMail(mail);
        }
        else{
            return "redirect:/depAdd";
        }

        if(validation.getTelephoneMatch(tel)){
            addedDepartment.setTel(tel);
        }
        else{
            return "redirect:/depAdd";
        }

        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
    /*
    // ---------------------------------------------Удаление отдела----------------------------------------------
    */
    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String Delete(@RequestParam(required = true) Integer id) {

        Department deleteDepartment = new Department();
        deleteDepartment.setId(id);

        try {
            departmentService.delete(deleteDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ---------------------------------------------Правка отдела------------------------------------------------
    */
    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public String Edit(@RequestParam(required = true) String name,
                       @RequestParam(required = true) Integer id,
                       @RequestParam(required = true) String mail,
                       @RequestParam(required = true) String tel) {

        Department editDepartment = new Department();
        editDepartment.setId(id);
        editDepartment.setName(name);
        editDepartment.setMail(mail);
        editDepartment.setTel(tel);

        try {
            departmentService.update(editDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ----------------------------------------Запуск страницы правки-------------------------------------------
    */
    @RequestMapping(value = "/depEditForm", method = RequestMethod.POST)
    public ModelAndView editPage(@RequestParam(required = true) Integer id) throws SQLException {

        Department getDepById = departmentService.getById(id);
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "getDepById", getDepById);
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */

}