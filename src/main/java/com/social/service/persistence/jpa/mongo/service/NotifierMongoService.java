package com.social.service.persistence.jpa.mongo.service;

import com.social.service.persistence.jpa.mongo.document.NotifierDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotifierMongoService {
    private final MongoOperations mongoOperations;

    public void deleteNotifier(String userName, String notifierUserName){
        Query query = new Query();
        query.addCriteria(Criteria.where("notifier").is(notifierUserName))
                .addCriteria(Criteria.where("user").is(userName));
        mongoOperations.remove(query, NotifierDocument.class);
    }

    public List<String> getNotifiersOfUser(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("user").is(userName));
        List<NotifierDocument> notifierDocuments = mongoOperations.find(query, NotifierDocument.class);
        if (CollectionUtils.isEmpty(notifierDocuments)){
            return Collections.emptyList();
        }
        return notifierDocuments.stream()
                .map(NotifierDocument::getNotifier)
                .collect(Collectors.toList());
    }
}
