package com.example.Laba_3_Web.deliveries;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Deliveries")
@AllArgsConstructor
@NoArgsConstructor
public class Deliveries {
    @Id
    @Column(name = "Code_delivery", nullable = false)
    private Long Code_delivery;
    @Column(name = "Name_delivery", nullable = false)
    private String Name_delivery;
    @Column(name = "Name_company", nullable = false)
    private String Name_company;
    @Column(name = "Address", nullable = false)
    private String Address;
    @Column(name = "Phone", nullable = false)
    private long Phone;
    @Column(name = "INN", nullable = false)
    private String INN;

    @Override
    public String toString() {
        return "{" +
                "Code_delivery=" + Code_delivery +
                ", Name_delivery='" + Name_delivery + '\'' +
                ", Name_company='" + Name_company + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone=" + Phone +
                ", INN='" + INN + '\'' +
                '}'+ '\n';
    }
}