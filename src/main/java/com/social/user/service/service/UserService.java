package com.social.user.service.service;

import com.social.user.service.client.UserServiceClient;
import com.social.user.service.persistence.jpa.UserProfileEntity;
import com.social.user.service.persistence.jpa.dto.UserDto;
import com.social.user.service.persistence.jpa.mongo.service.UserMongoService;
import com.social.user.service.persistence.jpa.response.UserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserServiceClient userClient;
    private final UserMongoService userMongoService;
    private final SocialUserService socialUserService;

    public UserProfileEntity getUser(String token) {
        ResponseEntity<UserProfileEntity> response = userClient.getUserDetail(token);
        return response.getBody();
    }

    @Transactional
    void assertUserExisted(String userName) {
        userMongoService.assertUserIsExisted(userName);
    }

    @Transactional
    public String getUserName(String token) {
        return socialUserService.getUserDetail(token).getUserName();
    }

    @Transactional
    public UserDetail getUserByDetail(String token) {
        return socialUserService.getUserDetail(token);
    }

    @Transactional
    void incFollowerCount(String userName) {
        userMongoService.incFollowerCount(userName);
    }

    @Transactional
    void incFollowingCount(String userName) {
        userMongoService.incFollowingCount(userName);
    }

    @Transactional
    void decreaseFollowerCount(String userName) {
        userMongoService.decreaseFollowerCount(userName);
    }

    @Transactional
    void increaseFollowingCount(String userName) {
        userMongoService.increaseFollowingCount(userName);
    }

    @Transactional
    void decreaseFollowingCount(String userName) {
        userMongoService.decreaseFollowingCount(userName);
    }

    public UserDto getUserBasicInfo(String userName) {
        return userMongoService.getUser(userName);
    }
}
