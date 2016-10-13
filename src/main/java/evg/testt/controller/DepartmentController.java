package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.Validation;
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
public class DepartmentController  {

    @Autowired
    DepartmentService departmentService;

    Validation validation;

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
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);

    }



//-================================================================



    @RequestMapping(value = "/depErr", method = RequestMethod.GET)
    public ModelAndView showErr() {
        return new ModelAndView(JspPath.DEPARTMENT_ERR);

    }

//================================================================


    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteDep(@RequestParam(required = true) Integer id) throws SQLException {
        Department deleteDepartment = new Department();
        deleteDepartment = departmentService.getById(id);
        departmentService.delete(deleteDepartment);
        return "redirect:/dep";
    }



    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView editDep(@RequestParam(required = true) Integer id) throws SQLException {
        Department editDepartment = new Department();
        editDepartment = departmentService.getById(id);

        return new ModelAndView(JspPath.DEPARTMENT_ADD, "editDepartment", editDepartment);



    }


    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,
                            @RequestParam(required = true) String depPhone,
                            @RequestParam(required = false) Integer id) throws SQLException {

        if(id==null){
            Department addedDepartment = new Department();


            if(Validation.validForDepartments(name)){
                addedDepartment.setName(name);

            }if(Validation.validForDepphone(depPhone)){
                addedDepartment.setDepPhone(depPhone);
            }
            else {

                return "redirect:/depErr";
            }

            try {
                departmentService.insert(addedDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/dep";

        }else{
            Department editDepartment = new Department();
            editDepartment = departmentService.getById(id);
            editDepartment.setName(name);
            editDepartment.setDepPhone(depPhone);
            departmentService.update(editDepartment);
            return "redirect:/dep";
        }








    }
}
