package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.persistence.jpa.mongo.converter.PostConverter;
import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.mongo.repository.PostRepository;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostMongoService {

    private final PostRepository postRepository;

    public void savePost(CreatePostRequest createPostRequest){
        PostDocument post = PostConverter.toDocument(createPostRequest);
        postRepository.save(post);
    }
}
