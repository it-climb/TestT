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

//--------------------------------------Страница Employees----------------------------------------

    @RequestMapping(value = "/empl", method = RequestMethod.POST)
    public ModelAndView showAll(@RequestParam(required = true) Integer id) {
        List<Employee> employees;
        Department department = new Department();

        try {
            department = departmentService.getById(id);
            employees = department.getEmployees();
        } catch (SQLException e) {
            department = null;
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }


//---------------------------------Добавление Employees-----------------------------------------------

    @RequestMapping(value = "/emplAdd", method = RequestMethod.POST)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.EMPLOYEE_ADD);
    }



//----------------------------------Удаление Employees-------------------------------------------------

        @RequestMapping(value = "/emplDelete", method = RequestMethod.POST)
    public String deleteDep(@RequestParam(required = true) Integer id) throws SQLException {
        Employee deleteEmployee = new Employee();
            deleteEmployee = employeeService.getById(id);
            employeeService.delete(deleteEmployee);
        return "redirect:/empl";
    }



    //------------------------------Изменение Employees----------------------------------------------

    @RequestMapping(value = "/emplEdit", method = RequestMethod.POST)
    public ModelAndView editDep(@RequestParam(required = true) Integer id) throws SQLException {
        Employee editEmployee = new Employee();
        editEmployee = employeeService.getById(id);

        return new ModelAndView(JspPath.EMPLOYEE_ADD, "editEmployee", editEmployee);
    }




//------------------------------Сохранение Employees------------------------------------------------

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName, String secondName,
                            @RequestParam(required = true) Integer id) throws SQLException {

        if(id==null){
            Employee addEmployee = new Employee();
            addEmployee.setFirstName(firstName);
            addEmployee.setSecondName(secondName);

            try {
                employeeService.insert(addEmployee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/empl";

        }else{
            Employee editEmployee = new Employee();
            editEmployee = employeeService.getById(id);
            editEmployee.setFirstName(firstName);
            editEmployee.setSecondName(secondName);
            employeeService.update(editEmployee);
            return "redirect:/empl";
        }}







}
