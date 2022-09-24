package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;
import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.service.PostMongoService;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Optional<PostDocument> getPostById(String id) {
        return postMongoService.getPostById(id);
    }

    public void insertLikePost(String userName, String postId) {
        Optional<PostDocument> post = getPostById(postId);
        LikeDocument likeDocument = LikeDocument.builder()
                        .userName(userName)
                .build();
        List<LikeDocument> likes = new ArrayList<>();
        likes.add(likeDocument);
        post.get().setLikes(likes);
        saveDocPost(post.get());
    }

    public void dislikePost(String userName, String postId) {
        Optional<PostDocument> post = getPostById(postId);
        post.get().getLikes().removeIf(likeDocument -> userName.contains(likeDocument.getUserName()));
        saveDocPost(post.get());
    }

}
