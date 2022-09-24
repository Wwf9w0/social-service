package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.service.LikeMongoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {

    private final LikeMongoService likeMongoService;
    private final PostService postService;

    public String getLikedPostForUser(String userName) {
        return likeMongoService.getLikeForUserName(userName);
    }


    public void insertLikePost(String userName, String postId) {
        Optional<PostDocument> post = postService.getPostById(postId);
        post.get().getLikes().forEach(like -> {
            like.setUserName(userName);
        });
        postService.saveDocPost(post.get());
    }
}
