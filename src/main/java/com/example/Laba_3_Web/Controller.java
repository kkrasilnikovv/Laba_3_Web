package com.example.Laba_3_Web;

import com.example.Laba_3_Web.author.AuthorRepository;
import com.example.Laba_3_Web.book.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class Controller {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping
    public String get() {
        return """
                <!DOCTYPE html>
                <html>
                 <head>
                  <meta charset="utf-8">
                  <title>Красильников ИДБ-21-10</title>
                 </head>
                 <body>
                 <h1>CRUD операции:</h1>
                 <br>
                  <form action="/authors" target="_blank">
                   <button>Авторы</button>
                  </form>
                  <br>
                  <br>
                  <form action="/publishingHouses" target="_blank">
                   <button>Издательские дома</button>
                  </form>
                  <br>
                  <br>
                  <form action="/books" target="_blank">
                   <button>Книги</button>
                  </form>
                  <br>
                  <br>
                  <form action="/deliveries" target="_blank">
                   <button>Доставляющие комании</button>
                  </form>
                  <br>
                  <br>
                  <form action="/purchases" target="_blank">
                   <button>Заказы</button>
                  </form>
                  <br>
                  <h1>Процедуры:</h1>
                  <br>
                  <form action="/one" target="_blank">
                   <button>Получить количество записей в таблице Books</button>
                  </form>
                  <br>
                  <br>
                  <form action="/fourteen" target="_blank">
                   <button>Заполнить первые 10 записей в таблице Author</button>
                  </form>
                  <br>
                  <br>
                  <form action="/seventeen" target="_blank">
                   <button>Преобразовать 2006.12.31 в формат день.месяц.год</button>
                  </form>
                 </body>
                </html>""";
    }

    @GetMapping("/one")
    @Transactional
    public int one() {
        return bookRepository.oneone();
    }

    @GetMapping("/fourteen")
    @Transactional
    public void fourteen() {
        authorRepository.fourteen();
    }

    @GetMapping("/seventeen")
    @Transactional
    public String seventeen() {
        return authorRepository.seventeen();
    }
}
