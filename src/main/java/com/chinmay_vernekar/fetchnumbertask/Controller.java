package com.chinmay_vernekar.fetchnumbertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    NumberModelService numberModelService;

    @PostMapping("/FetchNextNumber")
    public ResponseEntity<?> findNumber(@RequestBody CategoryCodeModel categoryCode) throws InterruptedException {
        System.out.println(categoryCode);
     return numberModelService.findNumber(categoryCode.getCategoryCode());
    }
}
