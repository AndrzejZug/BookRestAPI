package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(@Qualifier("jpaBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/delete/{id}")
    public String performDeleteBook(@Valid Book book, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/all";
        }
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String performEditBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show/{id}")
    public String showBook(@PathVariable Long id, Model model) {
//        List<Book> books = new ArrayList<>();
        Book book = bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book of specified ID not found");
        });
//        books.add(book);
        model.addAttribute("book", book);
        return "/books/show";
    }

}
