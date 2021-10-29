package com.example.server.services;

import com.example.server.models.Message;
import com.example.server.models.MessageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Message createMessage(Long email_id, Long contact_id){
        MessageKey messageKey = new MessageKey(email_id, contact_id);
        Message message = new Message(messageKey);
        return repository.save(message);
    }

    public Message updateClickTime(MessageKey id){
        Message message = repository.findById(id).get();
        message.setReceive_time(System.currentTimeMillis());
        return repository.save(message);
    }
}
