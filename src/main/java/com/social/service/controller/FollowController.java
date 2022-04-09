package com.social.service.controller;

import com.social.service.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequiredArgsConstructor-
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService;

    @PostMapping("/user/{userName}")
    public ResponseEntity<Void> followUser(@RequestHeader(AUTHORIZATION) String token,
                                           @PathVariable String userName){
        followService.follow(token, userName);
        return ResponseEntity<>(HttpStatus.OK);
    }

}
