package com.social.service.service.client;

import com.social.service.service.persistence.jpa.dto.UserDto;
import com.social.service.service.persistence.jpa.mongo.UserProfileEntity;
import com.social.service.service.persistence.jpa.response.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceClient {

    @GetMapping("/user-profile")
    ResponseEntity<UserProfileEntity> getUserDetail(@RequestHeader(AUTHORIZATION) String token);

    @GetMapping("/user-profile")
    ResponseEntity<UserDetail> getUserDetailPost(@RequestHeader(AUTHORIZATION) String token);

    @GetMapping("/user/profile")
    ResponseEntity<UserDto> getUserByProfileId(@PathVariable Long profileId);
}
