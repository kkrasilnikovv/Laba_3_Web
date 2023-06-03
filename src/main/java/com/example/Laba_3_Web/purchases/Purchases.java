package com.example.Laba_3_Web.purchases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Purchases")
@AllArgsConstructor
@NoArgsConstructor
public class Purchases {
    @Id
    @Column(name = "Code_purchase", nullable = false)
    private Long Code_purchase;
    @Column(name = "Code_book", nullable = false)
    private int Code_book;
    @Column(name = "Code_delivery", nullable = false)
    private int Code_delivery;
    @Column(name = "Type_purchase", nullable = false)
    private int Type_purchase;
    @Column(name = "Date_order", nullable = false)
    private LocalDate Date_order;
    @Column(name = "Cost", nullable = false)
    private float Cost;
    @Column(name = "Amount", nullable = false)
    private float Amount;
}