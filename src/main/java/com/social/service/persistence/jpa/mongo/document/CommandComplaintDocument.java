package com.social.service.persistence.jpa.mongo.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("CommandComplaint")
public class CommandComplaintDocument {

    @Id
    private String id;
    private Integer status;
    private String postId;
    private String commentId;
    private String answerId;
    private Long date;
    private String comment;
    private Long commentDate;
    private String commenterId;
    private List<ComplaintDocument> complaints;
}
