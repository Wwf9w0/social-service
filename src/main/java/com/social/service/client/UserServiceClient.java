package com.social.service.client;

import com.social.service.persistence.jpa.UserProfileEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceClient {

    @GetMapping("/user-profile")
    ResponseEntity<UserProfileEntity> getUserDetail(@RequestHeader(AUTHORIZATION) String token);
}
