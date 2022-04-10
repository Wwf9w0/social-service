package com.social.user.service.client;

import com.social.user.service.persistence.jpa.UserProfileEntity;
import com.social.user.service.persistence.jpa.response.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceClient {

    @GetMapping("/user-profile")
    ResponseEntity<UserProfileEntity> getUserDetail(@RequestHeader(AUTHORIZATION) String token);

    @GetMapping("/user-profile")
    ResponseEntity<UserDetail> getUserDetailPost(@RequestHeader(AUTHORIZATION) String token);
}
