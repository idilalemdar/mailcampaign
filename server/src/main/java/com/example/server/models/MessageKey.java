package com.example.server.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MessageKey implements Serializable {
    @Column(name = "contact_id")
    private Long contact_id;

    @Column(name = "email_id")
    private Long email_id;

    public MessageKey() {

    }

    public MessageKey(Long contact_id, Long email_id) {
        this.contact_id = contact_id;
        this.email_id = email_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageKey)) return false;

        MessageKey that = (MessageKey) o;

        if (!getContact_id().equals(that.getContact_id())) return false;
        return getEmail_id().equals(that.getEmail_id());
    }

    @Override
    public int hashCode() {
        int result = getContact_id().hashCode();
        result = 31 * result + getEmail_id().hashCode();
        return result;
    }

    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    public Long getEmail_id() {
        return email_id;
    }

    public void setEmail_id(Long email_id) {
        this.email_id = email_id;
    }
}
