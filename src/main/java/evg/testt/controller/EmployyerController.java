package evg.testt.controller;

import evg.testt.model.Employee;
import evg.testt.service.EmployyerService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller

public class EmployyerController {

    @Autowired
    EmployyerService employyerService;

    @RequestMapping(value = "/employeer/edit", method = RequestMethod.GET)
    public ModelAndView outPut(){
        List<Employee> employeers;
        try {
            employeers = employyerService.getAll();
        } catch (SQLException e) {
            employeers = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEERS_ALL, "employee", employeers);

    }

}
