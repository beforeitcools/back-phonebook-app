package com.ohgiraffers.phonebookbackend.controller;

import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import com.ohgiraffers.phonebookbackend.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phonebook")
public class SelectController
{
    @Autowired
    private SelectService selectService;

    @GetMapping("/select")
    public List<PhoneBook> selectAllContacts()
    {
        List<PhoneBook> contactList = selectService.selectAllContacts();
        System.out.println(contactList);
        return contactList;
    }

}
