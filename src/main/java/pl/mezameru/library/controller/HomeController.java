package pl.mezameru.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.model.User;
import pl.mezameru.library.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        if (!userService.getUserRepository().existsById(1L))
            userService.addWithDefaultRole(new User("admin", "admin"));
        return "home";
    }
}
