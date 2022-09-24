package com.social.service.service.persistence.jpa.mongo.converter;

import com.social.service.service.persistence.jpa.mongo.document.PostDocument;
import com.social.service.service.persistence.jpa.request.CreatePostRequest;

import java.time.LocalDateTime;

public class PostConverter {

    public static PostDocument toDocument(CreatePostRequest createPostRequest) {
        return PostDocument.builder()
                .userName(createPostRequest.getUserName())
                .shareDate(LocalDateTime.now())
                .status(createPostRequest.getStatus().getStatus())
                .pinned(createPostRequest.getPinned())
                .commentable(createPostRequest.getCommentable())
                .description(createPostRequest.getDescription())
                .build();
    }
}

