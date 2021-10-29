package com.example.server.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Contact",
        uniqueConstraints = @UniqueConstraint(columnNames ={"name", "email"}))
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;
    @Column
    private String email_address;

    @OneToMany(mappedBy = "email")
    Set<Message> messages;

    public Contact() {

    }

    public Contact(String name, String email_address) {
        this.name = name;
        this.email_address = email_address;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
