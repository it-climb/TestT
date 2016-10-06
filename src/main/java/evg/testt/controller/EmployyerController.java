package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.EmployyerService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployyerController {
    @Autowired
    EmployyerService employyerService;
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView outPut(){
        List<Employee> employeers;
        try {
            employeers = employyerService.getAll();
        } catch (SQLException e) {
            employeers = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEERS_ALL, "employee", employeers);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.EMPLOYEERS_ADD);
    }


    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, String surname, String patronymic, String mail,
                            String birthday, String tel, String position, String department, String project, String registration){

        Employee addedEmployee = new Employee();

        addedEmployee.setName(name);
        addedEmployee.setSurname(surname);
        addedEmployee.setPatronymic(patronymic);
        addedEmployee.setMail(mail);
        addedEmployee.setBirtday(birthday);
        addedEmployee.setTel_number(tel);
        addedEmployee.setPosition(position);
        addedEmployee.setDepartment(department);
        addedEmployee.setCurrent_project(project);
        addedEmployee.setDate_of_registration(registration);

        try {
            employyerService.insert(addedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }




}
