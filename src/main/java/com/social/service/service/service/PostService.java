package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.service.PostMongoService;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostMongoService postMongoService;

    public void savePost(CreatePostRequest createPostRequest) {
        postMongoService.savePost(createPostRequest);
    }

    public void saveDocPost(PostDocument post) {
        postMongoService.saveDocPost(post);
    }

    public Optional<PostDocument> getPostById(String id){
        return postMongoService.getPostById(id);
    }

}
