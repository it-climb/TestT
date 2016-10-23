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

    @RequestMapping(value = "/depAdd")
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) {
if (id != null)
{
    Department department = new Department();
    try {
        department = departmentService.getById(id);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return new ModelAndView(JspPath.DEPARTMENT_ADD, "departments", department);
}
else {
    return new ModelAndView(JspPath.DEPARTMENT_ADD);
}
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,
                            @RequestParam(required = false) Integer id) {


        if (id != null) {

            Department department = new Department();
            try {
                department = departmentService.getById(id);
                department.setName(name);
                departmentService.update(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "redirect:/dep";
        } else {
            Department department = new Department();
            department.setName(name);
            try {


                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "redirect:/dep";
        }
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteDep (@RequestParam(required = true) Integer id) throws SQLException {
        Department department = new Department();
        department.setId(id);
        departmentService.delete(department);
        return "redirect:/dep";
    }





}

