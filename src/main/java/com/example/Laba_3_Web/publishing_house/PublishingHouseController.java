package com.example.Laba_3_Web.publishing_house;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/publishingHouses")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @GetMapping
    public String getForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Издательские дома</title>
                </head>
                <body>
                 <h1>Издательские дома:</h1>
                 <form method="POST" action="/publishingHouses">
                 <br>
                  <label>Название:</label>
                  <input type="text" name="Publish">
                  <br>
                  <br>
                  <label>Город:</label>
                  <input type="text" name="City">
                  <br>
                  <br>
                  <input type="submit" value="Сохранить">
                 </form>
                 <br>
                  <br>
                 <form method="GET" action="/publishingHouses/deleteAll">
                    <button>Удалить все издательские дома</button>
                   </form>
                   <br>
                  <br>
                   <form method="GET" action="/publishingHouses/getAll">
                    <button>Показать все издательскиие дома</button>
                   </form>
                </body>
                </html>""";
    }

    @PostMapping()
    public void create(@RequestParam("Publish") String publish, @RequestParam("City") String city) {
        publishingHouseService.create(PublishingHouse.builder()
                .Publish(publish)
                .City(city)
                .build());
    }

    @GetMapping("/getAll")
    public String getAll() {
        return publishingHouseService.getAll();
    }
    @GetMapping("/deleteAll")
    public void deleteAll(){
        publishingHouseService.deleteAll();
    }
}
