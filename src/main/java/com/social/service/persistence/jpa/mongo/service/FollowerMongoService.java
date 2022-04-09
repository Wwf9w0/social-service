package com.social.service.persistence.jpa.mongo.service;

import com.social.service.persistence.jpa.mongo.document.FollowerDocument;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowerMongoService {

    private final MongoOperations mongoOperations;

    public void createFollower(String userName, String followingUserName){
        FollowerDocument  followerDocument = FollowerDocument.builder()
                .follower(userName)
                .following(followingUserName)
                .createdDate(DateTime.now().toDate())
                .build();
        mongoOperations.save(followerDocument);
    }
}
