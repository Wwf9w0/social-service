package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.persistence.jpa.mongo.converter.PostConverter;
import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.enums.PostStatus;
import com.social.service.service.persistence.jpa.mongo.repository.PostRepository;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import com.social.service.service.persistence.jpa.response.FollowingPostListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostMongoService {

    private final PostRepository postRepository;

    public void savePost(CreatePostRequest createPostRequest) {
        PostDocument post = PostConverter.toDocument(createPostRequest);
        postRepository.save(post);
    }

    public void saveDocPost(PostDocument postDocument) {
        postRepository.save(postDocument);
    }

    public void updatePost(String id, CreatePostRequest request){
        PostDocument post = getPostById(id).orElseThrow(RuntimeException::new);
        //TODO  need postUpdateRequest
        if (post.getStatus().equals(PostStatus.ACTIVE.getStatus())){
            post.setDescription(request.getDescription());
        }
        postRepository.save(post);
    }

    public Optional<PostDocument> getPostById(String id) {
        return postRepository.findById(id);
    }

    public FollowingPostListResponse getPostForFollowing(String userName) {
        PostDocument post = postRepository.findByUserName(userName);
        List<String> followingUsers = new ArrayList<>();
        List<PostDocument> postList = new ArrayList<>();
        post.getLikes().forEach(following -> {
            followingUsers.add(following.getUserName());
        });
        followingUsers.forEach(user -> {
            List<PostDocument> postDocuments = getFollowingUsersAllPosts(user);
            postList.addAll(postDocuments);
        });

        return FollowingPostListResponse.builder()
                .followingPostList(postList)
                .build();
    }

    public void deletePost(String id){
        Optional<PostDocument> post = getPostById(id);
        post.ifPresent(postRepository::delete);
    }

    public List<PostDocument> getFollowingUsersAllPosts(String userName) {
        List<PostDocument> posts = postRepository.findByUserNameAndShareDate(userName, LocalDateTime.now().minusDays(3));
        return posts;
    }

    public List<PostDocument> getFollowingPostForUser(String userName) {
        return postRepository.findByUserNameAndStatusAndShareDate(userName,
                PostStatus.ACTIVE.getStatus(), LocalDateTime.now().minusDays(3));
    }

    public boolean anyMatchUserName(List<PostDocument> postDocuments, String userName) {
        return postDocuments.stream().anyMatch(postDocument -> postDocument.getLikes().equals(userName));
    }
}
