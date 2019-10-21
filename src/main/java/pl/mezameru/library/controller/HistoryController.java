package pl.mezameru.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mezameru.library.service.UserService;

@Controller
public class HistoryController {
    @Autowired
    private UserService userService;

    @GetMapping("/history")
    public String second(Model model) {

        return "history";
    }
}
