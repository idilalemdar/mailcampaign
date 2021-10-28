package services;

import models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmailRepository;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository repository;

    public Email addEmail(Email email){
        return repository.save(email);
    }

    public Email getEmail(Long id){
        return repository.findById(id).get();
    }

    public List<Email> getALlEmails(){
        return (List<Email>) repository.findAll();
    }
}
