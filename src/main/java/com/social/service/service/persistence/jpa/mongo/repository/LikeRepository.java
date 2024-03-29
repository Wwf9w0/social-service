package com.social.service.service.persistence.jpa.mongo.repository;

import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<LikeDocument, String> {
    LikeDocument findByUserName(String userName);
}
