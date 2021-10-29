package com.example.server.services;

import com.example.server.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server.repository.EmailRepository;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository repository;

    public Email addEmail(Email email){
        return repository.save(email);
    }

    public Email getEmail(Long id){
        return respository.findById(id).get();
    }

    public List<Email> getAllEmails(){
        return (List<Email>) repository.findAll();
    }
}
