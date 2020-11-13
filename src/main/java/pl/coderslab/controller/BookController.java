package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")

public class BookController {
    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        return book;
    }

    @RequestMapping("")
    public List<Book> getList() {
        return memoryBookService.getBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book2) {
        memoryBookService.add(book2);
    }


    @RequestMapping(value = "/{id}")
    public Book getBookById(@PathVariable Long id) {
        return memoryBookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        memoryBookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        memoryBookService.update(book);
    }



//    @RequestMapping(path = "/form", method = RequestMethod.GET)
//    public String showForm() {
//        return "form";
//    }
//
//    @PostMapping("/form")
//    public String formBook(Model model, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
//        model.addAttribute("isbn", isbn);
//        model.addAttribute("title", title);
//        model.addAttribute("publisher", publisher);
//        model.addAttribute("type", type);
//
////        Book book = new Book(1L, isbn, title, author, publisher, type);
////        return book;
//        return "Name: " + title + " Date " + isbn;
//    }
}

