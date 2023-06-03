package com.example.Laba_3_Web.deliveries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries,Long> {
}
