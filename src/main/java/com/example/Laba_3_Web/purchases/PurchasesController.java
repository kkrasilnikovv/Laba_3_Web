package com.example.Laba_3_Web.purchases;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/purchases")
public class PurchasesController {
    private final PurchasesService purchasesService;

    @GetMapping
    public String getForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                 <title>Заказы</title>
                </head>
                <body>
                 <h1>Заказы:</h1>
                 <form method="POST" action="/purchases">
                 <br>
                  <label>Номер книги:</label>
                  <input type="text" name="Code_book">
                  <br>
                  <br>
                  <label>Дата заказа:</label>
                  <input type="date" name="Date_order">
                  <br>
                  <br>
                  <label>Номер доставки:</label>
                  <input type="text" name="Code_delivery">
                  <br>
                  <br>
                  <label>Тип доставки:</label>
                  <input type="text" name="Type_purchase">
                  <br>
                  <br>
                  <label>Стоимость:</label>
                  <input type="text" name="Cost">
                  <br>
                  <br>
                  <label>Количество:</label>
                  <input type="text" name="Amount">
                  <br>
                  <br>
                  <input type="submit" value="Сохранить">
                 </form>
                 <br>
                  <br>
                 <form method="GET" action="/books/deleteAll">
                    <button>Удалить все заказы</button>
                   </form>
                   <br>
                  <br>
                   <form method="GET" action="/books/getAll">
                    <button>Показать все заказы</button>
                   </form>
                </body>
                </html>""";
    }

    @PostMapping()
    public void create(@RequestParam("Code_book") String Code_book,
                       @RequestParam("Date_order") String Date_order,
                       @RequestParam("Code_delivery") String Code_delivery,
                       @RequestParam("Type_purchase") String Type_purchase,
                       @RequestParam("Cost") String Cost,
                       @RequestParam("Amount") String Amount
    ) {
        purchasesService.create(Purchases.builder()
                        .Code_book(Integer.parseInt(Code_book))
                        .Date_order(LocalDate.parse(Date_order))
                        .Code_delivery(Integer.parseInt(Code_delivery))
                        .Type_purchase(Integer.parseInt(Type_purchase))
                        .Cost(Float.parseFloat(Cost))
                        .Amount(Float.parseFloat(Amount))
                .build());
    }

    @GetMapping("/getAll")
    public String getAll() {
        return purchasesService.getAll();
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        purchasesService.deleteAll();
    }
}
