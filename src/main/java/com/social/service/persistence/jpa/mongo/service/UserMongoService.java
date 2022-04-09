package com.social.service.persistence.jpa.mongo.service;

import com.social.service.persistence.jpa.mongo.document.UserDocument;
import com.social.service.persistence.jpa.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserMongoService {
    private final MongoOperations mongoOperations;
    private final UserRepository userRepository;
    // private final PostService postService;

    public void assertUserIsExisted(String userName) {
        if (Objects.isNull(userRepository.findByUserName(userName))) {
            throw new RuntimeException();
        }
    }

    public void incFollowerCount(String userName){
        UserDocument userDocument = userRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)){
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowerCount())){
            userDocument.setFollowerCount(1);
        }else {
            userDocument.setFollowerCount(userDocument.getFollowerCount() + 1);
        }
        userRepository.save(userDocument);
    }

    public void incFollowingCount(String userName){
        UserDocument userDocument = userRepository.findByUserName(userName);

        if (Objects.isNull(userDocument)){
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowingCount())){
            userDocument.setFollowingCount(1);
        }else {
            userDocument.setFollowingCount(userDocument.getFollowingCount() + 1);
        }

        userRepository.save(userDocument);
    }
}
