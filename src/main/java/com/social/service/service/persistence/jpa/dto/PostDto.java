package com.social.service.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.social.service.service.persistence.jpa.mongo.document.CommentDocument;
import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private String id;
    private String hashTag;
    private String userName;
    private Integer status;
    private Boolean pinned;
    private LocalDateTime shareDate;
    private Boolean commentable;
    private String description;
    private List<LikeDto> likes;
    private List<CommentDto> comments;
}
