package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.service.impl.EmployeeServiceImpl;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import java.sql.SQLException;
import java.util.Set;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer id) throws SQLException {
        Department dep = null;
        dep = departmentService.getById(id);
        Set<Employee> employees = dep.getEmployees();
        ModelAndView modV = new ModelAndView(JspPath.EMPLOYEE_ALL);
        modV.addObject("employees", employees);
        modV.addObject("dep", dep);
        return modV;
    }

    @RequestMapping(value = "/EditEmpl", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(required = true) Integer id) throws SQLException {
        Employee editEmpl = null;
        editEmpl = employeeService.getById(id);
        return  new ModelAndView(JspPath.EMPLOYEE_ADD, "empl", editEmpl);
    }


    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = true) Integer dep) throws SQLException {
        Department depObj = null;
        depObj = departmentService.getById(dep);
        return new ModelAndView(JspPath.EMPLOYEE_ADD,"dep", depObj);
    }


    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = false) Integer id,
                            @RequestParam(required = false) Integer dep,
                            @RequestParam(required = true) String dateBirth) throws SQLException, ParseException {
        if ( id == null) {
            Employee addEmployee = new Employee();
            addEmployee.setFirstName(name);
            addEmployee.setSecondName(secondName);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            Date newdate= format.parse(dateBirth);
            addEmployee.setBirthday(newdate);
            Department depObj = null;
            depObj = departmentService.getById(dep);
            addEmployee.setDepartment(depObj);
            try {
                employeeService.insert(addEmployee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/dep";

        }
        else {

            Employee changeEmpl = employeeService.getById(id);
            changeEmpl.setFirstName(name);
            changeEmpl.setSecondName(secondName);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            Date newdate= format.parse(dateBirth);
            changeEmpl.setBirthday(newdate);

            try {
                employeeService.update(changeEmpl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/dep";
        }


    }

    @RequestMapping(value = "/deleteEmpl", method = RequestMethod.GET)
    public String delete(@RequestParam(required = true) Integer id) {
        Employee deleteEmpl = null;
        try {
            deleteEmpl = employeeService.getById(id);
            employeeService.delete(deleteEmpl);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
}
