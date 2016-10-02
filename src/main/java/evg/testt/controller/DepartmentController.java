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
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "dep", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String departmentName,
                            @RequestParam(required = false) Integer id) {
        Department department;
        if(id==null) {
            department = new Department();
            department.setName(departmentName);
            try {
                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {

            try {
                department = departmentService.getById(id);
                department.setName(departmentName);
                departmentService.update(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/dep";
    }
    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView EditOne (@RequestParam(required = true) Integer id){
        Department department = null;

        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_EDIT);
        modelAndView.addObject("dep", department);
        return modelAndView;
    }
    @RequestMapping(value = "/depDel", method = RequestMethod.POST)
    public String delOne(@RequestParam(required = true) Integer id) {
        Department department = new Department();
        department.setId(id);
        try {
            departmentService.delete(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
}
