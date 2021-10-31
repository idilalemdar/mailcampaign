package com.example.server.services;

import com.example.server.models.Message;
import com.example.server.models.MessageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Message getMessage(Long contact_id, Long email_id){
        MessageKey key = new MessageKey(contact_id, email_id);
        return repository.findById(key).get();
    }

    public Message createMessage(Message message){
        return repository.save(message);
    }

    public Message updateMessage(Message msg){
        return repository.save(msg);
    }

    public List<Message> getAllMessages() {
        return (List<Message>) repository.findAll();
    }
}
