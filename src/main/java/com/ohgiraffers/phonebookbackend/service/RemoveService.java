package com.ohgiraffers.phonebookbackend.service;

import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import com.ohgiraffers.phonebookbackend.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class RemoveService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;


    public String deletePhone(Map<String, String> deleteMenu) {

        if(Objects.isNull(deleteMenu)){
            return "삭제할 메뉴가 없습니다.";
        }

        int id = Integer.valueOf(deleteMenu.get("id"));
        
        PhoneBook phoneBook = phoneBookRepository.findById(id).orElse(null);
        phoneBookRepository.delete(phoneBook);

        return "delete 성공";
    }
}
