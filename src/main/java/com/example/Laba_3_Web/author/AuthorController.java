package com.example.Laba_3_Web.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public String getForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Авторы</title>
                </head>
                <body>
                 <h1>Авторы:</h1>
                 <form method="POST" action="/authors">
                 <br>
                  <label>Имя:</label>
                  <input type="text" name="name">
                  <br>
                  <br>
                  <label>Дата рождения:</label>
                  <input type="date" name="birthdate">
                  <br>
                  <br>
                  <input type="submit" value="Сохранить">
                 </form>
                 <br>
                  <br>
                 <form method="GET" action="/authors/deleteAll">
                    <button>Удалить всех авторов</button>
                   </form>
                   <br>
                  <br>
                   <form method="GET" action="/authors/getAll">
                    <button>Показать всех авторов</button>
                   </form>
                </body>
                </html>""";
    }

    @PostMapping()
    public void create(@RequestParam("name") String name, @RequestParam("birthdate") String birthdate) {
        authorService.create(Author.builder()
                .name_author(name)
                .Birthday(LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build());
    }

    @GetMapping("/getAll")
    public String getAll() {
        return authorService.getAll();
    }
    @GetMapping("/deleteAll")
    public void deleteAll(){
        authorService.deleteAll();
    }
}
