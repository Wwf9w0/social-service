package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.converter.UserConverter;
import com.social.service.service.persistence.jpa.dto.PreferencesDto;
import com.social.service.service.persistence.jpa.dto.UserDto;
import com.social.service.service.persistence.jpa.mongo.document.PreferencesDocument;
import com.social.service.service.persistence.jpa.mongo.document.UserDocument;
import com.social.service.service.persistence.jpa.mongo.repository.UserMongoRepository;
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
    private final UserMongoRepository userMongoRepository;
    // private final PostService postService;


    public UserDto getUser(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }

        UserDto userDto = UserConverter.toUserDto(userDocument);
        //TODO pp
        String profilePhoto = null;
        userDto.setProfilePhoto(profilePhoto);
        return userDto;
    }

    public void assertUserIsExisted(String userName) {
        if (Objects.isNull(userMongoRepository.findByUserName(userName))) {
            throw new RuntimeException();
        }
    }

    public void incFollowerCount(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowerCount())) {
            userDocument.setFollowerCount(1);
        } else {
            userDocument.setFollowerCount(userDocument.getFollowerCount() + 1);
        }
        userMongoRepository.save(userDocument);
    }

    public void incFollowingCount(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);

        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowingCount())) {
            userDocument.setFollowingCount(1);
        } else {
            userDocument.setFollowingCount(userDocument.getFollowingCount() + 1);
        }

        userMongoRepository.save(userDocument);
    }

    public void decreaseFollowerCount(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowerCount()) || userDocument.getFollowerCount() <= 0) {
            return;
        }

        userDocument.setFollowerCount(userDocument.getFollowerCount() - 1);
        mongoOperations.save(userDocument);
    }

    public void decreaseFollowingCount(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowingCount()) || userDocument.getFollowingCount() <= 0) {
            return;
        }

        userDocument.setFollowingCount(userDocument.getFollowingCount() - 1);
        mongoOperations.save(userDocument);
    }

    public void increaseFollowingCount(String userName) {
        UserDocument userDocument = userMongoRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowerCount())) {
            userDocument.setFollowerCount(1);
        } else {
            userDocument.setFollowerCount(userDocument.getFollowingCount() + 1);
        }

        mongoOperations.save(userDocument);
    }

    public PreferencesDto getPreferences(String userId){
        PreferencesDocument preferencesDocument = getPreferenceDocument(userId);
        return PreferencesDto.builder()
                .postCommentAllowed(preferencesDocument.isPostCommentAllowed())
                .profileOpen(preferencesDocument.isProfileOpen())
                .showUserName(preferencesDocument.isShowUserName())
                .showPostsToEveryone(preferencesDocument.isPostViewAllowedForEveryone())
                .build();
    }

    public PreferencesDocument getPreferenceDocument(String userId){
        UserDocument userDocument = mongoOperations.findById(userId, UserDocument.class);
        if (Objects.isNull(userDocument)){
            //TODO exception handle
            throw new RuntimeException();
        }
        return userDocument.getPreferences();
    }
}
