package repository;

import models.Message;
import models.MessageKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, MessageKey> {

}
