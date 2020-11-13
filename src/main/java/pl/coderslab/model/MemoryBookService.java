package pl.coderslab.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {

    private List<Book> books;
    private static Long nextId = 4L;
//    private final Logger logger = LoggerFactory.getLogger(SampleLoggerController.class);

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();

    }
//        for (Book book : getAllBooks()) {
//            if (book.getId().equals(Id)) return book;
//        }
//        throw new ResponseStatusException(
//                HttpStatus.NOT_FOUND, "entity not found"
//        );



    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
            book.setId(nextId++);
            books.add(book);
        }

    public Book EditBookById() {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (getBookById(id).isPresent()) {
            books.remove(this.getBookById(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.getBookById(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.getBookById(book.getId()).get());
            books.set(indexOf, book);
        }
    }


}
