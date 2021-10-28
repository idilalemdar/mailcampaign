package services;

import models.Message;
import models.MessageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MessageRepository;

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
