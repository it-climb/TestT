package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.apache.taglibs.standard.tag.common.xml.IfTag;
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
    public ModelAndView showAdd(@RequestParam(required = false) Integer id)  {
        Department depRef;
        if (id != null) {
        try {
            depRef = departmentService.getById(id);
                 } catch (SQLException e) {
            e.printStackTrace();
            depRef = null;
        }
            return new ModelAndView(JspPath.DEPARTMENT_ADD, "depRef", depRef);}
        else {
            return new ModelAndView(JspPath.DEPARTMENT_ADD);
        }



    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, @RequestParam(required = false) Integer id) {
        Department depRef;

        if (id != null) {
            try {
                depRef = departmentService.getById(id);
                depRef.setName(name);
                departmentService.update(depRef);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            Department addedDepartment = new Department();
            addedDepartment.setName(name);
            try {
                departmentService.insert(addedDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDel", method = RequestMethod.GET)
    public String depDel(@RequestParam(required = true) Integer id) {
        Department depRef;

        try {
            depRef = departmentService.getById(id);
            departmentService.delete(depRef);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
}
