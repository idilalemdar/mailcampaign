package com.example.server.controller;

import com.example.server.models.Message;
import com.example.server.models.Success;
import com.example.server.services.ContactService;
import com.example.server.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/read/{contact_id}/{email_id}")
    public ResponseEntity<Success> linkClicked(@PathVariable Long contact_id, @PathVariable Long email_id){
        Message msg = messageService.getMessage(contact_id, email_id);
        if(msg.getReceive_time() == -1){
            msg.setReceive_time(System.currentTimeMillis());
            messageService.updateMessage(msg);
        }
        return ResponseEntity.ok().body(new Success(contactService.getContactById(contact_id).getName()));
    }

    @GetMapping("/{contact_id}/{email_id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long contact_id, @PathVariable Long email_id){
        return ResponseEntity.ok().body(messageService.getMessage(contact_id, email_id));
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message){
        return ResponseEntity.ok().body(messageService.createMessage(message));
    }

}
