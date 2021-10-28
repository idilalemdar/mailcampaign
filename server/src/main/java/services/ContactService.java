package services;

import models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public Contact getContactById(Long id){
        return repository.findById(id).get();
    }
    public List<Contact> getAllContacts(){
        return (List<Contact>) repository.findAll();
    }
    public Contact addSingleContact(Contact contact){
        return repository.save(contact);
    }
    public List<Contact> addContacts(List<Contact> contacts){
        return (List<Contact>) repository.saveAll(contacts);
    }
}
