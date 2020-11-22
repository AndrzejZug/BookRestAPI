package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

//    private MemoryBookService memoryBookService;
//    @Autowired
//    public BookController(MemoryBookService memoryBookService) {
//        this.memoryBookService = memoryBookService;
//    }
    private BookService bookService;

    public BookController(@Qualifier("jpaBookService") BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        String strDateString = "2019-07-04";
        LocalDate localDate = LocalDate.parse(strDateString);
        System.out.println(localDate);
//        PrintWriter pw = new PrintWriter();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.parse("2019 09 20", formatter);
        return book;
    }

//    @RequestMapping("")
//    public List<Book> getList() {
//        return memoryBookService.getBooks();
//    }
    @GetMapping("")
    public @ResponseBody
    List<Book> getList() {
        return bookService.getBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }


//    @RequestMapping(value = "/{id}")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book of specified ID not found");
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
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

