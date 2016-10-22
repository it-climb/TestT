package evg.testt.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    @Qualifier("ovalValidator")
    Validator validator;

    @RequestMapping(value = "/allEmplInDep", method = {RequestMethod.GET,  RequestMethod.POST})
    public ModelAndView departmentsEmployees(@RequestParam(required = true) Integer depID) {

        Department department = departmentService.getById(depID);
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
//if "emplID != null -> Create new Employye, elle Edit Employee
    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public ModelAndView addNewOne(@ModelAttribute Employee employee,
                                  @RequestParam Integer depID) {
        List<ConstraintViolation> vialations;

        if(employee.getId() == null) {

            vialations = validator.validate(employee);

            if(vialations.size() == 0){
            employee.setDepartment(departmentService.getById(depID));
            employeeService.insert(employee);
            }else {
                return new ModelAndView((JspPath.EMPLOYEE_ADD), "vialations", vialations);
            }
        }else {
                departmentService.update(departmentService.getById(depID));
                employeeService.update(employee);
        }
        return new ModelAndView("redirect:/allEmplInDep?depID="+depID);

    }
    @RequestMapping(value = "/emplEdit", method = RequestMethod.POST)
    public ModelAndView EditOne (@RequestParam(required = true) Integer id, Integer depID){
        Employee employee = null;
        employee = employeeService.getById(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_EDIT, "empl", employee);
        modelAndView.addObject("depID", depID);
        return modelAndView;
    }
    @RequestMapping(value = "/emplDel", method = RequestMethod.POST)
    public String delOne(@RequestParam(required = true) Integer id, Integer depID) {
        Employee employee = new Employee();
        employee.setId(id);
        employeeService.delete(employee);
        return "redirect:/allEmplInDep?depID="+depID;
    }


}
