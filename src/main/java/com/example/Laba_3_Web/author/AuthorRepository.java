package com.example.Laba_3_Web.author;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Procedure(name = "fourteen")
    void fourteen();
    @Procedure(name = "seventeen")
    String seventeen();

}
