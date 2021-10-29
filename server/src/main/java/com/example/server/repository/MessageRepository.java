package com.example.server.repository;

import com.example.server.models.Message;
import com.example.server.models.MessageKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, MessageKey> {

}
