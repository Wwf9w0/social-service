package com.social.user.service.controller;

import com.social.user.service.persistence.jpa.dto.UserDto;
import com.social.user.service.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService;

    @PostMapping("/user/{userName}")
    public ResponseEntity<Void> followUser(@RequestHeader(AUTHORIZATION) String token,
                                           @PathVariable String userName){
        followService.follow(token, userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Void> unFollowUser(@RequestHeader(AUTHORIZATION) String token,
                                             @PathVariable String userName){
        followService.unFollow(token, userName);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/follower")
    public ResponseEntity<List<UserDto>> getFollowers(@RequestHeader(AUTHORIZATION) String token,
                                                      @RequestParam(name = "page") Integer page,
                                                      @RequestParam(name = "size" , defaultValue = "10") Integer size){
        return ResponseEntity.ok(followService.getFollowings(token, page, size));
    }

    @GetMapping("/follower/{userName}")
    public ResponseEntity<List<UserDto>> getFollowerOfUser(@RequestHeader(AUTHORIZATION) String token,
                                                           @RequestParam String userName,
                                                           @RequestParam(name = "page") Integer page,
                                                           @RequestParam(name = "size" , defaultValue = "10") Integer size){
        return ResponseEntity.ok(followService.getFollowersOfUser(token, userName, page, size));
    }

    @GetMapping("/following")
    public ResponseEntity<List<UserDto>> getFollowings(@RequestHeader(AUTHORIZATION) String token,
                                                       @RequestParam(name = "page") Integer page,
                                                       @RequestParam(name = "size" , defaultValue = "10") Integer size){
        return ResponseEntity.ok(followService.getFollowings(token, page, size));
    }

    @GetMapping("/following/{userName}")
    public ResponseEntity<List<UserDto>> getFollowingOfUser(@RequestHeader(AUTHORIZATION) String token,
                                                           @RequestParam String userName,
                                                           @RequestParam(name = "page") Integer page,
                                                           @RequestParam(name = "size" , defaultValue = "10") Integer size){
        return ResponseEntity.ok(followService.getFollowingsOfUser(token, userName, page, size));
    }

}
