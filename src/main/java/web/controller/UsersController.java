package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

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
      public String getUserById(@RequestParam(value = "id") Long id,
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
    public String create (@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          ModelMap model) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.save(user);

        model.addAttribute("user", user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam(value = "id") Long id,
                              ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/users/update")
    public String update (@RequestParam("id") Long id,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          ModelMap model) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.update(user);

        model.addAttribute("user", user);
        return "redirect:/users";
    }

}
