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
    EmployeeService employeeService;

    @RequestMapping(value = "/empl", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "empl", employees);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String departmentName,
                            @RequestParam(required = false) Integer id) {
        Department department;
        if(id==null) {
            department = new Department();
            department.setName(departmentName);
            try {
                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {

            try {
                department = departmentService.getById(id);
                department.setName(departmentName);
                departmentService.update(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/dep";
    }
    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView EditOne (@RequestParam(required = true) Integer id){
        Department department = null;

        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "dep", department);
    }
    @RequestMapping(value = "/depDel", method = RequestMethod.POST)
    public String delOne(@RequestParam(required = true) Integer id) {
        Department department = new Department();
        department.setId(id);
        try {
            departmentService.delete(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
}
