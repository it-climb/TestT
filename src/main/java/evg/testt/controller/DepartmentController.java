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
import java.util.HashMap;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        departments = departmentService.getAll();

        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }
//if "id" != null -> Create new Department, else Edit Department
    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String departmentName,
                            @RequestParam(required = false) Integer id) {
        Department department;
        if(id==null) {
            department = new Department();
            department.setName(departmentName);
            departmentService.insert(department);
        }else {
            department = departmentService.getById(id);
            department.setName(departmentName);
            departmentService.update(department);
        }
        return "redirect:/dep";
    }
    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView EditOne (@RequestParam(required = true) Integer id){
        Department department = null;
        department = departmentService.getById(id);
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_EDIT);
        modelAndView.addObject("dep", department);
        return modelAndView;
    }
    @RequestMapping(value = "/depDel", method = RequestMethod.POST)
    public String delOne(@RequestParam(required = true) Integer id) {
        Department department = departmentService.getById(id);
        departmentService.delete(department);
        return "redirect:/dep";
    }
}
