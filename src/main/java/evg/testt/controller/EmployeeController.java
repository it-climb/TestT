package evg.testt.controller;

import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
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

/**
 * Created by funtusthan on 26.10.16.
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.EMPLOYEE_EDIT);
    }

    @RequestMapping(value = "/empUpdate", method = RequestMethod.GET)
    public ModelAndView updateEmp(@RequestParam(required = true) Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        return new ModelAndView(JspPath.EMPLOYEE_EDIT, "employees", employee);
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer id) {
        Employee employee = new Employee();
        if (id == null) {
            try {
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employeeService.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                employee = employeeService.getById(id);
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/emp";
    }

    @RequestMapping(value = "/empDelete", method = RequestMethod.GET)
    public String deleteEmp(@RequestParam(required = true) Integer id) {
        try {
            Employee employee = employeeService.getById(id);
            employeeService.delete(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }
}
