package com.ohgiraffers.phonebookbackend.controller;

import com.ohgiraffers.phonebookbackend.service.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/phonebook")
public class RemoveController {

    @Autowired
    private RemoveService removeService;

    @PostMapping("/delete")
    public ResponseEntity deletePhonebook(@RequestBody Map<String, String> deleteMenu) {

        String result = removeService.deletePhone(deleteMenu);
        if(result != null){
            return ResponseEntity.ok("메뉴 삭제 성공");
        }
        return ResponseEntity.status(404).body("메뉴 삭제 실패");

    }
}
