package pl.mezameru.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mezameru.library.model.Loan;
import pl.mezameru.library.service.LoanService;
import pl.mezameru.library.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class HistoryController {
    private final LoanService loanService;

    @Autowired
    public HistoryController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/history")
    public String viewHistory(Model model, Principal principal) {
        List<Loan> userLoans = loanService.findAllByUsername(principal.getName());
        model.addAttribute("loans", userLoans);
        return "history";
    }
}
