package com.social.service.service;

import com.social.service.client.UserServiceClient;
import com.social.service.persistence.jpa.UserProfileEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserServiceClient userClient;

    public UserProfileEntity getUser(String token){
        ResponseEntity<UserProfileEntity> response = userClient.getUserDetail(token);
        return response.getBody();
    }
}
