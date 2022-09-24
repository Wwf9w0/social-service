package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.service.PostMongoService;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostMongoService postMongoService;

    public void savePost(CreatePostRequest createPostRequest) {
        postMongoService.savePost(createPostRequest);
    }
}
