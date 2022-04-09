package com.social.service.service;

import com.social.service.client.UserServiceClient;
import com.social.service.persistence.jpa.UserProfileEntity;
import com.social.service.persistence.jpa.mongo.service.FollowerMongoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class FollowService {

    private final UserServiceClient serviceClient;
    private final UserService userService;
    private FollowerMongoService followerMongoService;

    @Transactional
    public void follow(String token, String followUserName){
        String userName= userService.getUserName(token);

        try {
            userService.assertUserExisted(userName.toString());
            followerMongoService.createFollower(userName, followUserName);
            userService.incFollowerCount(userName);
            userService.incFollowingCount(userName);

        }catch (Exception e){
        log.warn(e.getMessage());
        }
    }

    @Transactional
    public void unFollow(String token, String followingUserName){
        String userName = userService.getUserName(token);
        long deleteCount = followerMongoService.deleteFollowing(userName, followingUserName);
        if (deleteCount < 1){
            return;
        }


    }

}
