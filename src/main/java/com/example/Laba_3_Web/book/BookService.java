package com.example.Laba_3_Web.book;

import com.example.Laba_3_Web.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private long id;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        id = 2;
    }

    public void create(Book book) {
        id++;
        book.setCode_book(id);
        bookRepository.save(book);
    }

    public String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Авторы</title>
                </head>
                <body>
                 <h1>Книги:</h1>""");
        List<Book> books = bookRepository.findAll();
        for (Book author : books) {
            stringBuilder.append(author.toString());
            stringBuilder.append("<br>\n" +
                    "                  <br>");
        }
        stringBuilder.append("</body>\n" +
                "                </html>");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        bookRepository.deleteAllInBatch();
    }
}
