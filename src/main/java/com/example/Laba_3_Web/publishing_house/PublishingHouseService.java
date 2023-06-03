package com.example.Laba_3_Web.publishing_house;

import com.example.Laba_3_Web.deliveries.Deliveries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingHouseService {
    private long id;
    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
        id = 2;
    }

    public void create(PublishingHouse publishingHouse) {
        id++;
        publishingHouse.setCode_publish(id);
        publishingHouseRepository.save(publishingHouse);
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
                 <h1>Издательства:</h1>""");
        List<PublishingHouse> deliveries = publishingHouseRepository.findAll();
        for (PublishingHouse author : deliveries) {
            stringBuilder.append(author.toString());
            stringBuilder.append("<br>\n" +
                    "                  <br>");
        }
        stringBuilder.append("</body>\n" +
                "                </html>");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        publishingHouseRepository.deleteAllInBatch();
    }
}
