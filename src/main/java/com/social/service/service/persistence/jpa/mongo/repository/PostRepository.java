package com.social.service.service.persistence.jpa.mongo.repository;

import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostDocument, String> {
}
