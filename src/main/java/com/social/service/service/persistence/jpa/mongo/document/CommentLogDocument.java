package com.social.service.service.persistence.jpa.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("CommentLog")
public class CommentLogDocument {

    private String id;
    private String userName;
    private String postId;
    private String commentId;
    private String answerId;
    private String comment;
    private Long date;
    private Integer status;
}
