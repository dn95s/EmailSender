package com.email.emailapi.controller;

import com.email.emailapi.model.EmailRequest;
import com.email.emailapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome(){
        return "hello this is my email api";
    }

    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){

        System.out.println(request);
        boolean result = emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        if(result) {
            return ResponseEntity.ok("Email wyslano poprawnie");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nie wyslano");
        }
    }

}
