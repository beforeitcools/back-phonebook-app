package com.ohgiraffers.phonebookbackend.service;

import com.ohgiraffers.phonebookbackend.dto.PhoneBookDTO;
import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import com.ohgiraffers.phonebookbackend.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    public Object updateContact(PhoneBookDTO contactData, String imgUrl) {
        PhoneBook phoneBook = phoneBookRepository.findById(contactData.getId()).orElse(null);

        if (phoneBook == null) {
            return "저장되어 있지 않은 연락처 입니다.";
        }else {
            phoneBook.setName(contactData.getName());
            phoneBook.setPhone(contactData.getPhoneNumber());
            if(!imgUrl.isEmpty()){
                phoneBook.setProfileImg(imgUrl);
            }
        }
        PhoneBook result = phoneBookRepository.save(phoneBook);
        return result;
    }
}
