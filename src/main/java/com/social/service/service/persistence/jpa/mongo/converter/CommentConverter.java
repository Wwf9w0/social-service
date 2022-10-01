package com.social.service.service.persistence.jpa.mongo.converter;

import com.social.service.service.persistence.jpa.dto.CommentDto;
import com.social.service.service.persistence.jpa.mongo.document.CommentDocument;

public class CommentConverter {

    public static CommentDto toDto (CommentDocument commentDocument){
        return CommentDto.builder()
                .comment(commentDocument.getComment())
                .userName(commentDocument.getUserName())
                .createdDate(commentDocument.getCreatedDate())
                .build();
    }
}
