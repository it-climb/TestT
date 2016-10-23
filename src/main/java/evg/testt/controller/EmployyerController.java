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

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployyerController {

    @Autowired
    EmployyerService employyerService;
    @Autowired
    DepartmentService departmentService;

    ValidationService validation = new ValidationService();
    /*
    // ------------------------------------------Вывод сотрудников-----------------------------------------------
    */
    @RequestMapping(value = "/empOutput", method = RequestMethod.POST)
    public ModelAndView outPut(@RequestParam(required = true)Integer idDep) {

        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEERS_OUTPUT);
        List<Employee> employeers;
        Department departments = new Department();
        try {
            employeers = departmentService.getById(idDep).getListEmpl();
            departments.getId();
        } catch (SQLException e) {
            employeers = Collections.emptyList();
            e.printStackTrace();
        }

        mav.addObject("employeers", employeers);
        mav.addObject("departments", departments);
        return mav;
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ---------------------------------Страница формы сохранения-------------------------------------
    */
    @RequestMapping(value = "/empAddForm", method = RequestMethod.POST)
    public ModelAndView showAdd(Integer id, @RequestParam(required = true) Integer idDep) {
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEERS_ADD);
        Employee addEmployee = new Employee();

        try{
            addEmployee = employyerService.getById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("employee", addEmployee);
        mav.addObject("idDep", idDep);
        return mav;
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ------------------------------------------Сохранение сотрудников------------------------------------------
    */
    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,
                            @RequestParam(required = true)  String surname,
                            @RequestParam(required = true) String mail,
                            @RequestParam(required = true)  Integer idDep,
                            @RequestParam(required = true)  Integer idEmp) {

        Employee saveEmployee = new Employee();
        Department depEmplSave = new Department();
        try {

            if(idEmp != null){

                saveEmployee = employyerService.getById(idEmp);
                saveEmployee.setName(name);
                saveEmployee.setSurname(surname);
                saveEmployee.setSurname(surname);
                saveEmployee.setMail(mail);
                employyerService.update(saveEmployee);
            }

            else {
                if (validation.getNameMatch(name)) {
                    saveEmployee.setName(name);
                } else {
                    return "redirect:/empEdit";
                }

                if (validation.getSurnameMatch(surname)) {
                    saveEmployee.setSurname(surname);
                } else {
                    return "redirect:/emp";
                }

                if (validation.getEmailMatch(mail)) {
                    saveEmployee.setMail(mail);
                } else {
                    return "redirect:/emp";
                }
                saveEmployee.setDepartments(departmentService.getById(idDep));
                employyerService.insert(saveEmployee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depOutPut";
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
    /*
    // ---------------------------------------------Удаление сотрудника----------------------------------------------
    */
    @RequestMapping(value = "/empDelete", method = RequestMethod.POST)
    public String DeleteEmp(@RequestParam(required = true) Integer id) {

        Employee delEmployee = new Employee();
        delEmployee.setId(id);
        try {
            employyerService.delete(delEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depOutPut";
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */
//    /*
//    // ---------------------------------------------Правка сотрудника------------------------------------------------
//    */
//    @RequestMapping(value = "/empEdit", method = RequestMethod.POST)
//    public String Edit(@RequestParam(required = true) String name,
//                       @RequestParam(required = true) String surname,
//                       @RequestParam(required = true) String mail,
//                       @RequestParam(required = true) Integer idDep) {
//
//        Employee editEmployee = new Employee();
//        editEmployee.setName(name);
//        editEmployee.setSurname(surname);
//        editEmployee.setMail(mail);
//
//        try {
//            employyerService.update(editEmployee);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/depOutPut";
//    }
//    /*
//    // -------------------------------------------------END------------------------------------------------------
//    */
    /*
    // ----------------------------------------Запуск страницы правки-------------------------------------------
    */
    @RequestMapping(value = "/empEditForm", method = RequestMethod.POST)
    public ModelAndView employeesEdit(@RequestParam(required = true) Integer idEmp) throws SQLException {

        //@RequestParam(required = true) Integer idDep,
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEERS_EDIT);
        Employee getEmpById = employyerService.getById(idEmp);
        //Department getDepById = departmentService.getById(idDep);
        mav.addObject("getEmpById", getEmpById);
        return mav;
    }
    /*
    // -------------------------------------------------END------------------------------------------------------
    */

}
