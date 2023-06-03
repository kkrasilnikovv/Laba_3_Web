package com.example.Laba_3_Web.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String getForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Книги</title>
                </head>
                <body>
                 <h1>Книги:</h1>
                 <form method="POST" action="/books">
                 <br>
                  <label>Название:</label>
                  <input type="text" name="Title_book">
                  <br>
                  <br>
                  <label>Количество страниц:</label>
                  <input type="text" name="Pages">
                  <br>
                  <br>
                  <label>Номер автора:</label>
                  <input type="text" name="Code_author">
                  <br>
                  <br>
                  <label>Номер издательства:</label>
                  <input type="text" name="Code_publish">
                  <br>
                  <br>
                  <input type="submit" value="Сохранить">
                 </form>
                 <br>
                  <br>
                 <form method="GET" action="/books/deleteAll">
                    <button>Удалить все книги</button>
                   </form>
                   <br>
                  <br>
                   <form method="GET" action="/books/getAll">
                    <button>Показать все книги</button>
                   </form>
                </body>
                </html>""";
    }

    @PostMapping()
    public void create(@RequestParam("Title_book") String Title_book, @RequestParam("Code_author") String Code_author,
                       @RequestParam("Pages") String Pages, @RequestParam("Code_publish") String Code_publish) {
        bookService.create(Book.builder()
                .Title_book(Title_book)
                .Code_author(Integer.parseInt(Code_author))
                .Pages(Integer.parseInt(Pages))
                .Code_publish(Integer.parseInt(Code_publish))
                .build());
    }

    @GetMapping("/getAll")
    public String getAll() {
        return bookService.getAll();
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        bookService.deleteAll();
    }
}
