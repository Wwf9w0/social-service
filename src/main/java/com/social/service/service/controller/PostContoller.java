package com.social.service.service.controller;

import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import com.social.service.service.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostContoller {
    private final PostService postService;

    @PostMapping("/crete")
    public ResponseEntity<HttpStatus> create(@RequestBody CreatePostRequest createPostRequest){
        postService.savePost(createPostRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
