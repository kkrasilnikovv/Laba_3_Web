package com.example.Laba_3_Web.deliveries;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/deliveries")
public class DeliveriesController {
    private final DeliveriesService deliveriesService;

    @GetMapping
    public String getForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Доставляющие компании</title>
                </head>
                <body>
                 <h1>Доставляющие компании:</h1>
                 <form method="POST" action="/deliveries">
                 <br>
                  <label>Название:</label>
                  <input type="text" name="Name_delivery">
                  <br>
                  <br>
                  <label>Название компании:</label>
                  <input type="text" name="Name_company">
                  <br>
                  <br>
                  <label>Адрес:</label>
                  <input type="text" name="Address">
                  <br>
                  <br>
                  <label>Номер телефона:</label>
                  <input type="text" name="Phone">
                  <br>
                  <br>
                  <label>ИНН:</label>
                  <input type="text" name="INN">
                  <br>
                  <br>
                  <input type="submit" value="Сохранить">
                 </form>
                 <br>
                  <br>
                 <form method="GET" action="/deliveries/deleteAll">
                    <button>Удалить все доставляющие компании</button>
                   </form>
                   <br>
                  <br>
                   <form method="GET" action="/deliveries/getAll">
                    <button>Показать все доставляющие компании</button>
                   </form>
                </body>
                </html>""";
    }

    @PostMapping()
    public void create(@RequestParam("Name_delivery") String Name_delivery, @RequestParam("Name_company") String Name_company,
                       @RequestParam("Address") String Address,
                       @RequestParam("Phone") String Phone, @RequestParam("INN") String INN) {
        deliveriesService.create(Deliveries.builder()
                .Name_delivery(Name_delivery)
                .Name_company(Name_company)
                .Phone(Long.parseLong(Phone))
                .Address(Address)
                .INN(INN)
                .build());
    }

    @GetMapping("/getAll")
    public String getAll() {
        return deliveriesService.getAll();
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        deliveriesService.deleteAll();
    }
}
