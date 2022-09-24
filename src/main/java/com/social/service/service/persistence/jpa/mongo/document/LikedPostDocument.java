package com.social.service.service.persistence.jpa.mongo.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Liked_Post_Document")
public class LikedPostDocument {

    @Id
    private String id;
    private String userName;
    private String postId;
    private LocalDateTime createdDate;
}
