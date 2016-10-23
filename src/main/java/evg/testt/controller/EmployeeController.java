package evg.testt.controller;

import evg.testt.model.Department;
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
 * Created by dima on 23.10.16.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer departmentId) {
        List<Employee> employees;
        employees= employeeService.getByDepartment(new Department(departmentId));
        return new ModelAndView(JspPath.EMPLOYEES_ALL, "employees", employees);
    }
}
