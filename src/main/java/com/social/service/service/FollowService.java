package com.social.service.service;

import com.social.service.client.UserServiceClient;
import com.social.service.persistence.jpa.UserProfileEntity;
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
    @Transactional
    public void follow(String token, String followUserName){
        ResponseEntity<UserProfileEntity> userName= serviceClient.getUserDetail(token);

        try {

        }catch (Exception e){

        }
    }

}
