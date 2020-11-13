package pl.coderslab.model;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
    void add(Book book);
    void delete(Long id);
    void update(Book book);
}
