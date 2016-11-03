package evg.testt.controller;


import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/empl", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam (required = true) Integer id){
        Department department;
       List <Employee> employees;
        ModelAndView modelAndView = new ModelAndView(JspPath.Employee_ALL);
        try{
            department = departmentService.getById(id);
          employees= department.getEmployees();
            modelAndView.addObject("employees" , employees);
            modelAndView.addObject("depId", id);
        }catch (Exception e){
            employees = null;
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = true) Integer id) {
        return new ModelAndView(JspPath.Employee_ADD, "depId", id);
    }

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String saveEmloyee(
            @RequestParam(required = true) Integer depId,
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String secondName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        List<Employee> list;
        Department department;

        try {
            department = departmentService.getById(depId);
            employee.setDepartments(department);
            list = department.getEmployees();
            list.add(employee);
            employeeService.insert(employee);
            employeeService.update(employee);
            departmentService.update(department);
        } catch (SQLException e) {
            department = null;
            e.printStackTrace();
        }
        return "redirect:/empl?id="+depId;
    }

    @RequestMapping(value = "/deleteEmpl", method = RequestMethod.GET)
    public String deleteEmployee (@RequestParam(required = true) Integer id)
    {
        //Department department;
        Employee employee = null;
        Integer idDep = null;
        //List<Employee> list;
        try{
            employee = employeeService.getById(id);
            idDep= employee.getDepartments().getId();
            //department = employee.getDepartments();
            //list = department.getEmployees();
            employeeService.delete(employee);
            //departmentService.update(department);

        }catch (SQLException e){
           // employee = null;
            e.printStackTrace();
        }
        return  "redirect:/empl?id="+idDep;
    }

//    @RequestMapping(value = "/emplEditSave", method = RequestMethod.GET)
//    public ModelAndView saveEditedEmployee(@Validated Employee employee) {
//
//        Employee newEmployee;
//        Department department;
//
//        try {
//            newEmployee = employeeService.getById(employee.getId());
//            newEmployee.setFirstName(employee.getFirstName());
//            newEmployee.setSecondName(employee.getSecondName());
//
//            employeeService.update(newEmployee);
//            department = newEmployee.getDepartments();
//
//        } catch (SQLException e) {
//            department = null;
//            e.printStackTrace();
//        }
//        return new ModelAndView(JspPath.Employee_ALL, "department", department);
//    }

//    @RequestMapping(value = "/emplEdit", method = RequestMethod.GET)
//    public ModelAndView editEmployee(@RequestParam(required = true) Integer id) {
//        Employee employee;
//        try {
//            employee = employeeService.getById(id);
//        } catch (SQLException e) {
//            employee = null;
//            e.printStackTrace();
//        }
//        return new ModelAndView(, "employee", employee);
//    }

}
