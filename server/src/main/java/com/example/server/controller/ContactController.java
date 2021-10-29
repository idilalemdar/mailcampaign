package com.example.server.controller;

import com.example.server.models.Contact;
import com.example.server.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contact")
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        return ResponseEntity.ok().body(contactService.addSingleContact(contact));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Contact>> batchCreate(@RequestBody List<Contact> contacts){
        return ResponseEntity.ok().body(contactService.addContacts(contacts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        return ResponseEntity.ok().body(contactService.getContactById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Contact>> getAllContacts(){
        return ResponseEntity.ok().body(contactService.getAllContacts());
    }
    
}
