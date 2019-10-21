package pl.mezameru.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {


    @GetMapping("/pass")
    public String pass() {
        return "account";
    }
}
