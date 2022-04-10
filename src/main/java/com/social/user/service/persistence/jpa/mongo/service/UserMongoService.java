package com.social.user.service.persistence.jpa.mongo.service;

import com.social.user.service.converter.UserConverter;
import com.social.user.service.persistence.jpa.dto.UserDto;
import com.social.user.service.persistence.jpa.mongo.document.UserDocument;
import com.social.user.service.persistence.jpa.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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


    public UserDto getUser(String userName) {
        UserDocument userDocument = userRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }

        UserDto userDto = UserConverter.toUserDto(userDocument);
        String profilePhoto = StringUtils.isEmpty(userDto.getProfilePhoto())
                //TODO pp
                ? null : null;
        userDto.setProfilePhoto(profilePhoto);
        return userDto;
    }

    public void assertUserIsExisted(String userName) {
        if (Objects.isNull(userRepository.findByUserName(userName))) {
            throw new RuntimeException();
        }
    }

    public void incFollowerCount(String userName) {
        UserDocument userDocument = userRepository.findByUserName(userName);
        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowerCount())) {
            userDocument.setFollowerCount(1);
        } else {
            userDocument.setFollowerCount(userDocument.getFollowerCount() + 1);
        }
        userRepository.save(userDocument);
    }

    public void incFollowingCount(String userName) {
        UserDocument userDocument = userRepository.findByUserName(userName);

        if (Objects.isNull(userDocument)) {
            throw new RuntimeException();
        }
        if (Objects.isNull(userDocument.getFollowingCount())) {
            userDocument.setFollowingCount(1);
        } else {
            userDocument.setFollowingCount(userDocument.getFollowingCount() + 1);
        }

        userRepository.save(userDocument);
    }

    public void decreaseFollowerCount(String userName) {
        UserDocument userDocument = userRepository.findByUserName(userName);
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
        UserDocument userDocument = userRepository.findByUserName(userName);
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
        UserDocument userDocument = userRepository.findByUserName(userName);
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
}
