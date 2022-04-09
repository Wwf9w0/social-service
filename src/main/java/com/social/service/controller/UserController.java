package com.social.service.controller;


import com.social.service.persistence.jpa.UserProfileEntity;
import com.social.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/detail")
    public ResponseEntity<UserProfileEntity> getUserDetail(@RequestHeader(AUTHORIZATION) String token){
        return ResponseEntity.ok(userService.getUser(token));
    }
}
