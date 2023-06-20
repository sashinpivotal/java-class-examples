package org.supamassirichotiyakul.catermate.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.supamassirichotiyakul.catermate.security.User;
import org.supamassirichotiyakul.catermate.security.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

//    @GetMapping("/showNewUserForm")
//    public String showNewForm(Model model) {
//        // create model attribute to bind form data
//        User user = new User();
//        model.addAttribute("user", user);
//        return "new_user";
//    }

//    @PostMapping("/saveUser")
//    public String save(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        System.out.println("user controller saveUser, user id: " + user.getId() + " first name: " + user.getFirstName());
//        System.out.println("user controller saveUser, user id: " + user.getId() + " role: " + user.getRoleSet());
//
//        if(bindingResult.hasErrors()) {
//            user.setFirstName("error");
//            return "new_user";
//        }
//        // save user to database
//        userService.saveUser(user);
//        return "redirect:/users";
//    }

    @PostMapping("/saveUser/{id}")
    public String registerUserAccount(@PathVariable(value = "id") long id,
                                      @ModelAttribute("user") @Valid User user,
                                      BindingResult result) {

        Logger logger = LoggerFactory.getLogger(UserController.class);

        if (result.hasErrors()) {
            return "redirect:/users";
        }

        userService.updateUser(user);

        logger.info("User with email " + user.getEmail() + " has been updated");

        return "redirect:/users";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get user from the service
        User user = userService.getUserById(id);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        // call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
}
