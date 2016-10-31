package evg.testt.controller;

import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.model.UserDetails;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.RoleService;
import evg.testt.service.UserDetailsService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    RoleService roleService;

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = {"", "/", "home"})
    public ModelAndView homePage() {
        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView showUsersFromPost() {
        return showUsers();
    }

    @RequestMapping(value = "/users")
    public ModelAndView showUsers() {
        List<User> users;
        try {
            users = userService.getAll();
        } catch (SQLException e) {
            users = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.USERS_ALL, "users", users);
    }

    @RequestMapping(value = "/userAdd")
    public ModelAndView addUser() {
        return new ModelAndView(JspPath.USERS_ADD);
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        try {
            userService.insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/users";
    }

    @RequestMapping(value = "/userAddRole", method = RequestMethod.GET)
    public ModelAndView addRole(@RequestParam int id) {
        User user;
        ModelAndView model;
        try {
            user = userService.getById(id);
        } catch (SQLException e) {
            user = null;
            e.printStackTrace();
        }
        if (user.getRole() != null) {
            return showUsers();
        } else {
            model = new ModelAndView(JspPath.USERS_ADD_ROLE);
        }
        model.addObject("role", new Role());
        model.addObject("user_id", id);
        return model;
    }

    @RequestMapping(value = "/userAddRole", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("role") Role role, @RequestParam int id) {
        User user;
        try {
            user = userService.getById(id);
            user.setRole(role);
            role.setUser(user);
            roleService.update(role);
            userService.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/users";
    }

    @RequestMapping(value = "userDel")
    public String deleteUser(@RequestParam int id) {
        User user;
        Role role;
        try {
            user = userService.getById(id);
            role = user.getRole();
            user.setRole(null);
            roleService.delete(role);
            userService.update(user);
            userService.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/users";
    }

    @RequestMapping(value = "/userEdit")
    public ModelAndView editUser(@RequestParam int id, Model model) throws SQLException {
        if (!userService.isExists(id)) {
            return showUsers();
        }
        User user = userService.getById(id);
        if (user.getUserDetails() != null) {
            model.addAttribute("userDetails", user.getUserDetails());
        } else {
            model.addAttribute("userDetails", new UserDetails());
        }
        model.addAttribute("id", id);
        return new ModelAndView(JspPath.USERS_EDIT);
    }

    @RequestMapping(value = "/userSaveEdited")
    public ModelAndView saveAfterEdit(@ModelAttribute("userDetails") @Validated UserDetails userDetails,
                                      BindingResult result, @RequestParam int id, Model model) throws SQLException {
        if (!userService.isExists(id)) {
            return showUsers();
        }
        validator.validate(userDetails, result);
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return new ModelAndView(JspPath.USERS_EDIT);
        } else {
            User user = userService.getById(id);
            userDetails.setUser(user);
            if (user.getUserDetails().getId() != null) {
                userDetailsService.update(userDetails);
            } else {
                userDetailsService.insert(userDetails);
            }
            return showUsers();
        }
    }
}
