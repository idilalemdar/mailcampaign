package com.example.server.controller;

import com.example.server.models.Email;
import com.example.server.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/email")
@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmail(@PathVariable long id){
        return ResponseEntity.ok().body(emailService.getEmail(id));
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails(){
        return ResponseEntity.ok().body(emailService.getAllEmails());
    }

    @PostMapping
    public ResponseEntity<Email> addEmail(@RequestBody Email email){
        return ResponseEntity.ok().body(emailService.addEmail(email));
    }
}
