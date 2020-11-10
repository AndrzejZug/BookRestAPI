package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")

public class BookController {
    public MemoryBookService memoryBookService;

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
    public List<Book> listAllBooks() {
        return memoryBookService.getAllBooks();
    }


    @RequestMapping(value = "/{id}")
    public Book getBookById(@PathVariable Long id) {
        return memoryBookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
        }
    }

