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

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer depId) {
        List<Employee> employees;
        try {
            employees = departmentService.getById(depId).getEmployeeList();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ALL);
        mav.addObject("employees",employees);
        mav.addObject("depId",depId);
        return mav;
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id, @RequestParam(required = true) Integer depId) {

        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ADD);
        Employee addEmployee = new Employee();
        try {
            addEmployee = employeeService.getById(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            mav.addObject("employee", addEmployee);
            mav.addObject("depId", depId);
            return mav;
        }
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.GET)
    public String addNewOne(@RequestParam(required = true) String firstName, @RequestParam(required = true) String secondName, @RequestParam(required = false) Integer id, @RequestParam(required = true) Integer depId) {
        Employee updateEmployee = new Employee();
        try {
            if (id != null) {
                updateEmployee = employeeService.getById(id);
                updateEmployee.setFirstName(firstName);
                updateEmployee.setSecondName(secondName);
                employeeService.update(updateEmployee);
            }
            else{
                updateEmployee.setFirstName(firstName);
                updateEmployee.setSecondName(secondName);
                updateEmployee.setDepartment(departmentService.getById(depId));
                employeeService.insert(updateEmployee);
            }
            departmentService.update(departmentService.getById(depId));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?depId="+depId;
    }
    @RequestMapping(value = "/empDel", method = RequestMethod.POST)
    public String delEmp(@RequestParam(required = true) Integer id) {
        try {
            Employee delEmployee = employeeService.getById(id);
            employeeService.delete(delEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }
}
