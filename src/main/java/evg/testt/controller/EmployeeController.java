package evg.testt.controller;

import evg.testt.model.Department;
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
 * Created by abonent63 on 25.09.16.
 */
@Controller
public class EmployeeController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/allEmplInDep", method = {RequestMethod.GET,  RequestMethod.POST})
    public ModelAndView departmentsEmployees(@RequestParam(required = true) Integer depID) {

        Department department = new Department(depID);
        List<Employee> employees = employeeService.getByDepartment(department);

        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL, "allEmplInDep", employees);
        modelAndView.addObject("department", department);
        return modelAndView;
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.POST)
    public ModelAndView showNewEmployeePage(@RequestParam(required = true)Integer depID) {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ADD);
        modelAndView.addObject("depID", depID);
        return modelAndView;
    }

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String employeeFirstName, String employeeSecondName,Integer depID,
                            @RequestParam(required = false) Integer emplID) {
        Employee employee;
        if(emplID == null) {
            employee = new Employee();
            employee.setFirstName(employeeFirstName);
            employee.setSecondName(employeeSecondName);

            try {
                employee.setDepartment(departmentService.getById(depID));
                employeeService.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {

            try {
                employee = employeeService.getById(emplID);
                employee.setFirstName(employeeFirstName);
                employee.setSecondName(employeeSecondName);
                departmentService.update(departmentService.getById(depID));
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/allEmplInDep?depID="+depID;

    }
    @RequestMapping(value = "/emplEdit", method = RequestMethod.POST)
    public ModelAndView EditOne (@RequestParam(required = true) Integer id, Integer depID){
        Employee employee = null;

        try {
            employee = employeeService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_EDIT, "empl", employee);
        modelAndView.addObject("depID", depID);
        return modelAndView;
    }
    @RequestMapping(value = "/emplDel", method = RequestMethod.POST)
    public String delOne(@RequestParam(required = true) Integer id, Integer depID) {
        Employee employee = new Employee();
        employee.setId(id);
        try {
            employeeService.delete(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/allEmplInDep?depID="+depID;
    }
}
