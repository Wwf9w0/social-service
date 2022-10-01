package com.social.service.service.persistence.jpa.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Comment")
public class CommentDocument {

    @Id
    private String id;
    private String userName;
    private String comment;
    private Long createdDate;
}
