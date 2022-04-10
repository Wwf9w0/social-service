package com.social.user.service.persistence.jpa.mongo.service;

import com.mongodb.client.result.DeleteResult;
import com.social.user.service.persistence.jpa.mongo.document.FollowerDocument;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowerMongoService {

    private final MongoOperations mongoOperations;

    public void createFollower(String userName, String followingUserName) {
        FollowerDocument followerDocument = FollowerDocument.builder()
                .follower(userName)
                .following(followingUserName)
                .createdDate(DateTime.now().toDate())
                .build();
        mongoOperations.save(followerDocument);
    }

    public long deleteFollowing(String userName, String followingUserName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("follower").is(userName))
                .addCriteria(Criteria.where("following").is(followingUserName));
        DeleteResult deleteResult = mongoOperations.remove(query, FollowerDocument.class);
        return deleteResult.getDeletedCount();
    }

    public List<String> getFollowingIds(String userName, Integer page, Integer size) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(page, size);
        query.addCriteria(Criteria.where("following").is(userName)).with(pageable);
        List<FollowerDocument> followerDocuments = mongoOperations.find(query, FollowerDocument.class);
        if (CollectionUtils.isEmpty(followerDocuments)) {
            return Collections.emptyList();
        }
        return followerDocuments.stream()
                .map(FollowerDocument::getFollowing)
                .collect(Collectors.toList());
    }

    public List<String> getFollowerIds(String userName, Integer page, Integer size) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(page, size);
        query.addCriteria(Criteria.where("follower").is(userName)).with(pageable);
        List<FollowerDocument> followerDocuments = mongoOperations.find(query, FollowerDocument.class);
        if (CollectionUtils.isEmpty(followerDocuments)) {
            return Collections.emptyList();
        }
        return followerDocuments.stream()
                .map(FollowerDocument::getFollower)
                .collect(Collectors.toList());
    }
}
