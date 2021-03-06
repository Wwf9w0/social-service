package com.social.user.service.persistence.jpa.mongo.repository;

import com.social.user.service.persistence.jpa.mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByUserName(String userName);

}
