package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsersList(ModelMap model){
        model.addAttribute("users", userService.listUsers());
        return "usersList";
    }

    @GetMapping("/user")
      public String getUserById(@RequestParam("id") Long id,
        ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "userById";
    }

    @GetMapping("/users/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String create (@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }

        userService.save(user);
        //model.addAttribute("user", user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam("id") Long id,
                              ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/users/update")
//    public String update (@RequestParam("id") Long id,
//                          @RequestParam("firstName") @Valid String firstName, BindingResult b1,
//                          @RequestParam("lastName") @Valid String lastName, BindingResult b2,
//                          @RequestParam("email") @Valid String email, BindingResult b3,
//                          ModelMap model) {
    public String update (@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }

        userService.update(user);
        //model.addAttribute("user", user);
        return "redirect:/users";
    }

    @PostMapping("/user/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
