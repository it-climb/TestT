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

/**
 * Created by funtusthan on 26.10.16.
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL);
        Department department = departmentService.getById(id);
        modelAndView.addObject("department",department);
        modelAndView.addObject("employees", employeeService.getByDepartment(department));
        return modelAndView;
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
                            @RequestParam(required = true) Integer id_department) throws SQLException {
        Department department = departmentService.getById(id_department);
        Employee employee = new Employee();
        employee.setDepartment(department);
        if (id_department == null) {
            try {
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employeeService.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                employee = employeeService.getById(id_department);
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/emp?id"+id_department;
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
