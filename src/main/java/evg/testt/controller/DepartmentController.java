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

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, String mail, String tel) {

        Department addedDepartment = new Department();

        addedDepartment.setName(name);
        addedDepartment.setMail(mail);
        addedDepartment.setTel(tel);

        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String Delete(@RequestParam(required = true) Integer id) {

        Department deleteDepartment = new Department();
        deleteDepartment.setId(id);
        try {
            departmentService.delete(deleteDepartment);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "department/edit", method = RequestMethod.POST)
    public String Edit(@RequestParam(required = true) String name, Integer id){

        Department editDepartment = new Department();
        editDepartment.setId(id);
        editDepartment.setName(name);

        try{
            departmentService.update(editDepartment);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


}