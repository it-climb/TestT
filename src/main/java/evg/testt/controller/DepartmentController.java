package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

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
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);

    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.GET)
    public String deleteDep(@RequestParam(required = true) Integer id) throws SQLException {
        Department deleteDepartment = new Department();
        deleteDepartment = departmentService.getById(id);
        departmentService.delete(deleteDepartment);
        return "redirect:/dep";
    }



    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView editDep(@RequestParam(required = true) Integer id) throws SQLException {
        Department editDepartment = new Department();
        editDepartment = departmentService.getById(id);

        return new ModelAndView(JspPath.DEPARTMENT_ADD, "editDepartment", editDepartment);



    }






    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, @RequestParam(required = false) Integer id) throws SQLException {

        if(id==null){
            Department addedDepartment = new Department();
            addedDepartment.setName(name);

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
            departmentService.update(editDepartment);
            return "redirect:/dep";
        }








    }


}
