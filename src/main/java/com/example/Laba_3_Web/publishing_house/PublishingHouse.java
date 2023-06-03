package com.example.Laba_3_Web.publishing_house;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Publishing_house")
@AllArgsConstructor
@NoArgsConstructor
public class PublishingHouse {
    @Id
    @Column(name = "Code_publish", nullable = false)
    private Long Code_publish;
    @Column(name = "Publish", nullable = false)
    private String Publish;
    @Column(name = "City", nullable = false)
    private String City;

    @Override
    public String toString() {
        return "{" +
                "Code_publish=" + Code_publish +
                ", Publish='" + Publish + '\'' +
                ", City='" + City + '\'' +
                '}'+ '\n';
    }
}