package com.social.service.service.persistence.jpa.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Post")
public class PostDocument {

    @Id
    private String id;
    private String userName;
    private List<LikeDocument> likes;
    private List<CommentDocument> comments;
    private LocalDateTime shareDate;
    private Integer status;
    private Integer followerCount;
    private Boolean pinned;
    private Boolean commentable;
    private String description;
}
