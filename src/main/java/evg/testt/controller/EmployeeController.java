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
public class EmployeeController{
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

//--------------------------------------Страница Employees----------------------------------------

    @RequestMapping(value = "/empl")
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
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }


//---------------------------------Добавление Employees-----------------------------------------------

    @RequestMapping(value = "/emplAdd", method = RequestMethod.POST)
    public ModelAndView showAdd(@RequestParam(required = true) Integer idDep) throws SQLException {
        Department addDepEmpl = new Department();
        addDepEmpl = departmentService.getById(idDep);
        ModelAndView mav = new ModelAndView(JspPath.EMPLOYEE_ADD);
        mav.addObject("department", addDepEmpl);
        return mav;
    }



//----------------------------------Удаление Employees-------------------------------------------------

        @RequestMapping(value = "/emplDelete", method = RequestMethod.POST)
    public String deleteEmpl(@RequestParam(required = true) Integer idDep,
                             @RequestParam(required = true) Integer idEmpl) throws SQLException {

            Department depEmplDel = new Department();
            Employee deleteEmployee = new Employee();
            List<Employee> employeeList;

            depEmplDel = departmentService.getById(idDep);
            deleteEmployee = employeeService.getById(idEmpl);
            employeeList = depEmplDel.getEmployees();
            employeeList.remove(deleteEmployee);
            departmentService.update(depEmplDel);
            employeeService.delete(deleteEmployee);

        return "redirect:/empl?id="+idDep;
    }




    //------------------------------Изменение Employees----------------------------------------------

    @RequestMapping(value = "/emplEdit", method = RequestMethod.POST)
    public ModelAndView editEmpl(@RequestParam(required = true) Integer idDep,
                                 @RequestParam(required = true) Integer idEmpl) throws SQLException {
        Department editEmplDep = departmentService.getById(idDep);
        Employee editEmployee = employeeService.getById(idEmpl);
//        List<Employee> employeeList = editEmplDep.getEmployees();

//        editEmplDep = departmentService.getById(idDep);
//        editEmployee = employeeService.getById(idEmpl);
//        employeeList = editEmplDep.getEmployees();


        ModelAndView mavEdit = new ModelAndView(JspPath.EMPLOYEE_ADD);


        mavEdit.addObject("department", editEmplDep);
        mavEdit.addObject("employee", editEmployee);
//        employeeList.remove(editEmployee);
//        departmentService.update(editEmplDep);
        return mavEdit;
    }




//------------------------------Сохранение Employees------------------------------------------------

    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer idDep,
                            @RequestParam(required = false) Integer idEmpl) throws SQLException {

        if(idEmpl==null){
            Employee addEmployee = new Employee();
            Department depEmplSave = new Department();
            depEmplSave = departmentService.getById(idDep);
            addEmployee.setDepartments(depEmplSave);
            addEmployee.setFirstName(firstName);
            addEmployee.setSecondName(secondName);

            try {
                employeeService.insert(addEmployee);
                employeeService.update(addEmployee);
                departmentService.update(depEmplSave);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/empl?id="+idDep;

        }else{
            Employee editEmployee = new Employee();
            Department editEmplDep = new Department();
            editEmplDep = departmentService.getById(idDep);
            editEmployee = employeeService.getById(idEmpl);
            editEmployee.setFirstName(firstName);
            editEmployee.setSecondName(secondName);
            departmentService.update(editEmplDep);
            employeeService.update(editEmployee);




            return "redirect:/empl?id="+idDep;
        }}







}
