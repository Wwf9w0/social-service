package com.social.service.service.persistence.jpa.mongo.converter;

import com.social.service.service.persistence.jpa.dto.PostDto;
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

    public static PostDto toDto(PostDocument postDocument){
        return PostDto.builder()
                .id(postDocument.getId())
                .userName(postDocument.getUserName())
                .shareDate(postDocument.getShareDate())
                .status(postDocument.getStatus())
                .pinned(postDocument.getPinned())
                .commentable(postDocument.getCommentable())
                .description(postDocument.getDescription())
                .build();
    }
}

