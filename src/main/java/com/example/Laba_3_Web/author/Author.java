package com.example.Laba_3_Web.author;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Authors")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @Column(name = "Code_author", nullable = false)
    private Long Code_author;
    @Column(name = "name_author", nullable = false)
    private String name_author;
    @Column(name = "Birthday", nullable = false)
    private LocalDate Birthday;

    @Override
    public String toString() {
        return "{" +
                "Code_author=" + Code_author +
                ", name_author='" + name_author + '\'' +
                ", Birthday=" + Birthday +
                '}' + '\n';
    }
}