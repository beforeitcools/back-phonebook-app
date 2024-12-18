package com.ohgiraffers.phonebookbackend.service;

import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import com.ohgiraffers.phonebookbackend.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService
{
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    public List<PhoneBook> selectAllContacts()
    {
        List<PhoneBook> contactsList = phoneBookRepository.findAll();
        if(contactsList.isEmpty()){
            return null;
        }
        return contactsList;
    }
}
