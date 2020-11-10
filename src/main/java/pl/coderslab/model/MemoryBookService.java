package pl.coderslab.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService {

    private List<Book> list;
    private static Long nextId = 4L;
//    private final Logger logger = LoggerFactory.getLogger(SampleLoggerController.class);

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Optional<Book> getBookById(Long id) {
        return list.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
//        for (Book book : getAllBooks()) {
//            if (book.getId().equals(Id)) return book;
//        }
//        throw new ResponseStatusException(
//                HttpStatus.NOT_FOUND, "entity not found"
//        );



    public List<Book> getAllBooks() {
        return list;
    }

    public Book EditBookById() {
        return null;
    }

    public Book DeleteBookById() {
        return null;
    }

}
