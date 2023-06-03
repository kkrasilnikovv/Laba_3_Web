package com.example.Laba_3_Web.purchases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesService {
    private long id;
    private final PurchasesRepository purchasesRepository;

    @Autowired
    public PurchasesService(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
        id = 2;
    }

    public void create(Purchases book) {
        id++;
        book.setCode_purchase(id);
        purchasesRepository.save(book);
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
        List<Purchases> books = purchasesRepository.findAll();
        for (Purchases author : books) {
            stringBuilder.append(author.toString());
            stringBuilder.append("<br>\n" +
                    "                  <br>");
        }
        stringBuilder.append("</body>\n" +
                "                </html>");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        purchasesRepository.deleteAllInBatch();
    }
}
