package com.example.server.models;

import javax.persistence.*;

@Entity
public class Message {
    @EmbeddedId
    MessageKey id;

    @ManyToOne
    @MapsId("contact_id")
    @JoinColumn(name = "contact_id")
    Contact contact;

    @ManyToOne
    @MapsId("email_id")
    @JoinColumn(name = "email_id")
    Email email;

    @Column(name = "send_time")
    private long send_time;

    @Column(name = "receive_time")
    private long receive_time;

    public Message() {
    }

    public Message(MessageKey id) {
        this.id = id;
        this.send_time = System.currentTimeMillis();
        receive_time = -1;
    }

    public MessageKey getId() {
        return id;
    }

    public void setId(MessageKey id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public long getSend_time() {
        return send_time;
    }

    public void setSend_time(long send_time) {
        this.send_time = send_time;
    }

    public long getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(long receive_time) {
        this.receive_time = receive_time;
    }
}
