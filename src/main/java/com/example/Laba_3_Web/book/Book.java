package com.example.Laba_3_Web.book;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "Code_book", nullable = false)
    private Long Code_book;
    @Column(name = "Title_book", nullable = false)
    private String Title_book;
    @Column(name = "Pages", nullable = false)
    private int Pages;
    @Column(name = "Code_author", nullable = false)
    private int Code_author;
    @Column(name = "Code_publish", nullable = false)
    private int Code_publish;

    @Override
    public String toString() {
        return "{" +
                "Code_book=" + Code_book +
                ", Title_book='" + Title_book + '\'' +
                ", Pages=" + Pages +
                ", Code_author=" + Code_author +
                ", Code_publish=" + Code_publish +
                '}'+ '\n';
    }
}