package com.example.Laba_3_Web.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private long id;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        id = 10;
    }

    public void create(Author author) {
        id++;
        author.setCode_author(id);
        authorRepository.save(author);
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
                 <h1>Авторы:</h1>""");
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            stringBuilder.append(author.toString());
            stringBuilder.append("<br>\n" +
                    "                  <br>");
        }
        stringBuilder.append("</body>\n" +
                "                </html>");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        authorRepository.deleteAllInBatch();
    }
}
