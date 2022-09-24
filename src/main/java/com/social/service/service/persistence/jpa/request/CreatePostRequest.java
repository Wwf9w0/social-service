package com.social.service.service.persistence.jpa.request;

import com.social.service.service.persistence.jpa.mongo.document.CommentDocument;
import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequest {

    private String userName;
    private LocalDateTime shareDate;
    private Integer status;
    private Boolean pinned;
    private Boolean commentable;
    private String description;
}
