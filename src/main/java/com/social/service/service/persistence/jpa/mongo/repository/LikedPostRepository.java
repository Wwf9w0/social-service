package com.social.service.service.persistence.jpa.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import  com.social.service.service.persistence.jpa.mongo.document.LikedPostDocument;

import java.util.List;

public interface LikedPostRepository extends MongoRepository<LikedPostDocument, String> {

    List<LikedPostDocument> findByUserName(String userName);
}
