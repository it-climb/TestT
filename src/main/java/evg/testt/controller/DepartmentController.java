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
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) throws SQLException {
        if(id!=null) {
            Department department = departmentService.getById(id);
            ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ADD);
            modelAndView.addObject("department", department);
            return modelAndView;
        } else {
            return  new ModelAndView(JspPath.DEPARTMENT_ADD);
        }
    }


    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, @RequestParam(required = false) Integer departmentId) {
        if(departmentId==null) {
            Department addedDepartment = new Department();
            addedDepartment.setName(name);
            try {
                departmentService.insert(addedDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Department department = departmentService.getById(departmentId);
                department.setName(name);
                departmentService.update(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/dep";
    }

    @RequestMapping (value = "/depDelete", method = RequestMethod.GET)
    public String deleteNewOne (@RequestParam(required = false) Integer id) {
        Department deleteDepartment;
        try {
            departmentService.delete(deleteDepartment = departmentService.getById(id));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

}
