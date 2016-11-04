package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;
import java.util.jar.Attributes;

@Controller
public class UserController {

    /*Validator validator = new Validator();

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) {
       if (id != null){
            try {
                Department updateDepartment = departmentService.getById(id);
                return new ModelAndView(JspPath.DEPARTMENT_ADD, "department", updateDepartment);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,@RequestParam(required = false) Integer id) {

        List<ConstraintViolation> violations;

        try {
            if (id != null) {
                Department updateDepartment = departmentService.getById(id);
                updateDepartment.setName(name);
                violations = validator.validate(updateDepartment);
                if (violations.size() > 0){
                    violations = null;
                    return "redirect:/depAdd?id="+id;
                }

                departmentService.update(updateDepartment);
            }
            else{
                Department addedDepartment = new Department();
                addedDepartment.setName(name);
                violations = validator.validate(addedDepartment);
                if (violations.size() > 0){
                    violations = null;
                    return "redirect:/depAdd?id="+id;
                }
                departmentService.insert(addedDepartment);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
    @RequestMapping(value = "/depDel", method = RequestMethod.POST)
    public String delDep(@RequestParam(required = true) Integer id) {
        try {
            Department delDepartment = departmentService.getById(id);
            departmentService.delete(delDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }*/
}
