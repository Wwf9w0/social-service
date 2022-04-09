package com.social.service.service;

import com.social.service.client.UserServiceClient;
import com.social.service.persistence.jpa.response.UserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocialUserService {
    private final UserServiceClient client;

    public UserDetail getUserDetail(String token){
        ResponseEntity<UserDetail> userDetail = client.getUserDetailPost(token);
        if (Objects.isNull(userDetail) || Objects.isNull(userDetail.getBody())){
            return null;
        }
        return userDetail.getBody();
    }


}
