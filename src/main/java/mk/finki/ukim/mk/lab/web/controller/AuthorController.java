package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final BookService bookService;
    private final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



@GetMapping
public String listAuthors(HttpServletRequest req, Model model)
{
    model.addAttribute("authors",authorService.listAuthors());
    String isbn= (String) req.getSession().getAttribute("isbn");
    model.addAttribute("isbn",isbn);
    model.addAttribute("authors",authorService.listAuthors());
    return "authorList";

}
    @PostMapping
    public String AddAuthorToBook(HttpServletRequest request,@RequestParam String authorId, Model model)
    {
        Long id=Long.valueOf((String)authorId);
        model.addAttribute("id",id);
        String isbn=(String)request.getSession().getAttribute("isbn");
        bookService.addAuthorToBook(id,isbn);
        return "redirect:/bookdetails";

    }
}
