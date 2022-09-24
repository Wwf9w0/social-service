package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;
import com.social.service.service.persistence.jpa.mongo.document.LikedPostDocument;
import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.enums.PostFilterType;
import com.social.service.service.persistence.jpa.mongo.service.PostMongoService;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostMongoService postMongoService;
    private final LikedPostService likedPostService;

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
        LikedPostDocument likedPost = LikedPostDocument.builder()
                .postId(postId)
                .userName(userName)
                .createdDate(LocalDateTime.now()).build();
        likedPostService.save(likedPost);
        saveDocPost(post.get());
    }

    public void dislikePost(String userName, String postId) {
        Optional<PostDocument> post = getPostById(postId);
        post.get().getLikes().removeIf(likeDocument -> userName.contains(likeDocument.getUserName()));
        saveDocPost(post.get());
    }


    public List<PostDocument> filter(List<PostDocument> posts, PostFilterType postFilterType) {
        if (CollectionUtils.isEmpty(posts)) {
            return posts;
        }

        if (Objects.nonNull(postFilterType)) {
            posts = filterPost(posts, postFilterType);
        }

        return posts;
    }


    private List<PostDocument> filterPost(List<PostDocument> postDocuments, PostFilterType postFilterType) {

        if (shouldPostFilterFollower(postFilterType)) {
            return postDocuments.stream()
                    .sorted(Comparator.comparing(PostDocument::getFollowerCount))
                    .collect(Collectors.toList());
        }

        if (shouldPostFilterDate(postFilterType)) {
            return postDocuments.stream()
                    .sorted(Comparator.comparing(PostDocument::getShareDate).reversed())
                    .collect(Collectors.toList());
        }
        return postDocuments;
    }

    private boolean shouldPostFilterDate(PostFilterType postFilterType) {
        return Objects.equals(postFilterType, PostFilterType.SHARE_DATE);
    }

    private boolean shouldPostFilterFollower(PostFilterType postFilterType) {
        return Objects.equals(postFilterType, PostFilterType.FOLLOWER_COUNT);
    }

}
