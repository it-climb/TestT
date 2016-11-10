package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;
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
    public ModelAndView showAdd(@RequestParam(required = false) Integer id,
                                @RequestParam(required = false) String name) {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ADD);
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNew(@RequestParam(required = true) String name,
                            @RequestParam(required = false) Integer id) throws SQLException {
        Department department = new Department();
        if (id == null) {
            department.setName(name);
            departmentService.insert(department);
        } else {
            department = departmentService.getById(id);
            department.setName(name);
            departmentService.update(department);
        }

        return "redirect:/dep";
    }

    @RequestMapping(value = "/deleteDep", method = RequestMethod.GET)
    public String deleteDep(@RequestParam(required = true) Integer id) throws SQLException {
        Department department = departmentService.getById(id);
        departmentService.delete(department);
        return "redirect:/dep";
    }
}

