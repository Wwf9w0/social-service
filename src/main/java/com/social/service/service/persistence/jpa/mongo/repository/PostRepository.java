package com.social.service.service.persistence.jpa.mongo.repository;

import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends MongoRepository<PostDocument, String> {

    PostDocument findByUserName(String userName);
    List<PostDocument> findByUserNameAndShareDate(String userName, LocalDateTime dateTime);
    List<PostDocument> findByUserNameAndStatusAndShareDate(String userName, Integer status, LocalDateTime dateTime);

}
