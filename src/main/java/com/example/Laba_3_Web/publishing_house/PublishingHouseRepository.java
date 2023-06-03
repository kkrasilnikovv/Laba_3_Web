package com.example.Laba_3_Web.publishing_house;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse,Long> {
}
