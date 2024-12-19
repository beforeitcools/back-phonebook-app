package com.ohgiraffers.phonebookbackend.controller;

import com.ohgiraffers.phonebookbackend.dto.PhoneBookDTO;
import com.ohgiraffers.phonebookbackend.entity.PhoneBook;
import com.ohgiraffers.phonebookbackend.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/phonebook")
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @PostMapping("/update")
    public ResponseEntity updateContact(@RequestParam("contactData") PhoneBookDTO contactData, @RequestParam("image") MultipartFile image) {
        String imgUrl = "";

        if(!Objects.isNull(image)){
            String savePath = "C:/phonebook/profile_pic";
            File fileDir = new File(savePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }

            String originalFileName = image.getOriginalFilename();
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
            String filePath = savePath + "/" + savedName;
            imgUrl = filePath;

            try {
                image.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미지 업로드 실패");
            }
        }

        Object result = updateService.updateContact(contactData, imgUrl);
        if(result instanceof PhoneBook){
            PhoneBook response = (PhoneBook) result;
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).body(result);
    }
}
