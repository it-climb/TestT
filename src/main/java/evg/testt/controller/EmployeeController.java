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
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/empl", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer id) {
        List<Employee> employee;
        Department department;
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL);
        try {
            department = departmentService.getById(id);
            employee = department.getEmployees();

        } catch (SQLException e) {
            employee = null;
            e.printStackTrace();
        }
        modelAndView.addObject("employees", employee);
        modelAndView.addObject("department_id", id);
        return modelAndView;

    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer employee_id,
                                @RequestParam(required = false) Integer department_id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ADD);
        Department department = null;
        Employee employee = null;
        if (department_id != null) {
            try {
                department = departmentService.getById(department_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (employee_id != null) {
            try {
                employee = employeeService.getById(employee_id);
                department = employee.getDepartments();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("department", department);
        return modelAndView;

    }

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String secondName,
            @RequestParam(required = true) Integer department_id,
            @RequestParam(required = true) Integer employee_id) {
        Employee employee;
        Department department;
        if (employee_id == null) {
            employee = new Employee();
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            try {
                department = departmentService.getById(department_id);
                employee.setDepartments(department);
                employeeService.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                department = departmentService.getById(department_id);
                  employee = employeeService.getById(employee_id);
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employee.setDepartments(department);
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/empl?id=" + department_id;
    }

//    @RequestMapping(value = "/emplDelete", method = RequestMethod.GET)
//    public String deleteEmployee(@RequestParam(required = true) Integer employee_id) {
//        Integer department_id = null;
//        Employee employee;
//        try {
//            employee = employeeService.getById(employee_id);
//              employeeService.delete(employee);
//            department_id = employee.getDepartments().getId();
//        } catch (SQLException e) {
//            employee = null;
//            e.printStackTrace();
//        }
//        return "redirect:/empl?id=" + department_id;
//    }
//}

    @RequestMapping(value = "/emplDelete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam(required = true) Integer employee_id) throws SQLException {
        Employee employee = employeeService.getById(employee_id);
        Department department = employee.getDepartments();
        department.getEmployees().remove(employee);
        departmentService.update(department);
         Integer department_id = employee.getDepartments().getId();
        return "redirect:/empl?id=" + department_id;
    }
}
