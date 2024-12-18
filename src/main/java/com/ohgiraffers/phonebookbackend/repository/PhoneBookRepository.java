package com.ohgiraffers.phonebookbackend.repository;

import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {
    PhoneBook findById(int id);
}
