package com.social.service.service.service;

import com.social.service.service.client.UserServiceClient;
import com.social.service.service.persistence.jpa.dto.UserDto;
import com.social.service.service.persistence.jpa.response.UserDetail;
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

    public UserDetail getUserDetail(String token) {
        ResponseEntity<UserDetail> userDetail = client.getUserDetailPost(token);
        if (Objects.isNull(userDetail) || Objects.isNull(userDetail.getBody())) {
            return null;
        }
        return userDetail.getBody();
    }

    public UserDto getUserByProfileId(Long profileId) {
        final ResponseEntity<UserDto> user = client.getUserByProfileId(profileId);
        if (Objects.isNull(user) || Objects.isNull(user.getBody())) {
            return null;
        }
        return user.getBody();
    }
}
