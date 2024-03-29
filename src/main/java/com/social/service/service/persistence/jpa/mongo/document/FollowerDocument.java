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
@Document("Follower")
@CompoundIndexes({
        @CompoundIndex(name = "follower_index", def = "{'follower' :1, 'following': 1}", unique = true)
})
public class FollowerDocument {

    private String follower;
    private String following;
    private Date createdDate;
}
