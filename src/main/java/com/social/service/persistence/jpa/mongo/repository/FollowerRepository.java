package com.social.service.persistence.jpa.mongo.repository;

import com.social.service.persistence.jpa.mongo.document.FollowerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowerRepository extends MongoRepository<FollowerDocument, String> {

        FollowerDocument findByUserName(String userName);
}
