package com.social.service.service.persistence.jpa.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("UserLikedPosts")
@CompoundIndexes({
        @CompoundIndex(name = "Like_index", def = "{'userName' : 1, 'postId': 1}", unique = true)
})
public class UserLikedPostDocument {

    private String userName;
    private String postId;
    private Date createdDate;
}
