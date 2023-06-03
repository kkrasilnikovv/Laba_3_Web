package com.example.Laba_3_Web.deliveries;

import com.example.Laba_3_Web.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveriesService {
    private long id;
    private final DeliveriesRepository deliveriesRepository;

    @Autowired
    public DeliveriesService(DeliveriesRepository deliveriesRepository) {
        this.deliveriesRepository = deliveriesRepository;
        id = 1;
    }

    public void create(Deliveries deliveries) {
        id++;
        deliveries.setCode_delivery(id);
        deliveriesRepository.save(deliveries);
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
                 <h1>Компании доставки:</h1>""");
        List<Deliveries> deliveries = deliveriesRepository.findAll();
        for (Deliveries author : deliveries) {
            stringBuilder.append(author.toString());
            stringBuilder.append("<br>\n" +
                    "                  <br>");
        }
        stringBuilder.append("</body>\n" +
                "                </html>");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        deliveriesRepository.deleteAllInBatch();
    }
}
