package evg.testt.controller;

import evg.testt.model.Person;
import evg.testt.model.User;
import evg.testt.service.PersonService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
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
public class PersonController {

   /* Validator validator = new Validator();

    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer depId) {
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ALL);
        List<User> users;
        try {
            users = personService.getById(depId).getUserList();
        } catch (SQLException e) {
            users = Collections.emptyList();
            e.printStackTrace();
        }
        mav.addObject("users",users);
        mav.addObject("depId",depId);
        return mav;
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id, @RequestParam(required = true) Integer depId) {
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ADD);
        Person addPerson = new Person();
        try {
            addPerson = personService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
        mav.addObject("person", addPerson);
        mav.addObject("depId", depId);
        return mav;
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.GET)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = false) Integer id,
                            @RequestParam(required = true) Integer depId) {

        Person updatePerson = new Person();

        List<ConstraintViolation> violations;

        try {
            if (id != null) {
                updatePerson = personService.getById(id);
                updatePerson.setFirstName(firstName);
                updatePerson.setSecondName(secondName);
                violations = validator.validate(updatePerson);
                if (violations.size() > 0){
                    violations = null;
                    return "redirect:/empAdd?depId="+depId;
                }
                personService.update(updatePerson);
            }
            else{
                updatePerson.setFirstName(firstName);
                updatePerson.setSecondName(secondName);
                //updatePerson.setUserList(departmentService.getById(depId));
                violations = validator.validate(updatePerson);
                if (violations.size() > 0){
                    violations = null;
                    return "redirect:/empAdd?depId="+depId;
                }
                personService.insert(updatePerson);
            }
            personService.update(personService.getById(depId));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?depId="+depId;
    }

    @RequestMapping(value = "/empDel", method = RequestMethod.POST)
    public String delEmp(@RequestParam(required = true) Integer id) {
        Integer depId = 0;
        try {

            Employee delEmployee = employeeService.getById(id);

            Department department = delEmployee.getDepartments();

            depId = department.getId();

            List<Employee> employeeList = department.getEmployeeList();

            employeeList.remove(delEmployee);

            departmentService.update(department);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?depId="+depId;
    }
    */
}
