package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.Employee;

import evg.testt.service.DepartmentService;
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
 * Created by Яна on 30.10.2016.
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam (required = true) Integer depId) {
        List<Employee> employees;
        Department department;
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL);
        try {
            department = departmentService.getById(depId);
            employees = department.getEmployees();
            modelAndView.addObject("employees", employees);
            modelAndView.addObject("depId", depId);
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return modelAndView;
    }

/*    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) throws SQLException {

        if(id!=null) {
            Employee employee = employeeService.getById(id);
            ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ADD);
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            return  new ModelAndView(JspPath.EMPLOYEE_ADD);
        }
    } */

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ADD);
        Department department;
        List<Department> departments = departmentService.getAll();
        for (Department department1 : departments) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~"+department1.getName());
        }
        if(id!=null) {
            Employee employee = employeeService.getById(id);
            modelAndView.addObject("departments", departments);
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            return  modelAndView;
        }
    }


    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = false) Integer employeeId) {
        if(employeeId==null) {
            Employee addedEmployee = new Employee();
            addedEmployee.setFirstName(firstName);
            addedEmployee.setSecondName(secondName);
            try {
                employeeService.insert(addedEmployee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try{
                Employee employee = employeeService.getById(employeeId);
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return "redirect:/emp";
    }

    @RequestMapping (value = "/empDelete", method = RequestMethod.GET)
    public String deleteNewOne (@RequestParam(required = false) Integer id) {
        Employee deleteEmployee;
        try {
            employeeService.delete(deleteEmployee = employeeService.getById(id));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/emp";
    }


}
