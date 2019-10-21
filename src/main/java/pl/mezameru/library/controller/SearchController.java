package pl.mezameru.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.mezameru.library.model.Book;
import pl.mezameru.library.model.Loan;
import pl.mezameru.library.model.User;
import pl.mezameru.library.service.BookService;
import pl.mezameru.library.service.LoanService;
import pl.mezameru.library.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {
    private final BookService bookService;
    private final LoanService loanService;
    private final UserService userService;

    @Autowired
    public SearchController(BookService bookService, LoanService loanService, UserService userService) {
        this.bookService = bookService;
        this.loanService = loanService;
        this.userService = userService;
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("book", new Book());
        return "search";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Book book, Model model) {
        List<Book> books = bookService.findBookByForm(book);
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "search";
    }

    @RequestMapping("/borrow")
    public String borrow(@Param("id") Long id,
                         Principal principal,
                         RedirectAttributes redirectAttributes) {
        Book book = bookService.findBookById(id);
        if (!book.isAvailable()) {
            Loan loan = loanService.findNotReturnedBook(book);
            System.out.println(loan.getBook().toString());
            redirectAttributes.addFlashAttribute("loan", loan);
            return "redirect:error_borrow";
        }
        User user = userService.findUserByUsername(principal.getName());
        Loan loan = loanService.loanBook(book, user);
        redirectAttributes.addFlashAttribute("loan", loan);
        return "redirect:success_borrow";
    }

    @GetMapping("/success_borrow")
    public String successBorrow(@ModelAttribute Loan loan, Model model) {
        model.addAttribute("loan", loan);
        return "success_borrow";
    }

    @GetMapping("/error_borrow")
    public String errorBorrow(@ModelAttribute Loan loan, Model model) {
        model.addAttribute("loan", loan);
        return "error_borrow";
    }


}
