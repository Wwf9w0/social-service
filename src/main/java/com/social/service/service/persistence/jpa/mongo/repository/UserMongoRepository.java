package com.social.service.service.persistence.jpa.mongo.repository;

import com.social.service.service.persistence.jpa.mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByUserName(String userName);
}
