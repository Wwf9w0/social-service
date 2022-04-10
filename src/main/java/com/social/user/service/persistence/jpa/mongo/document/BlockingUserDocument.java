package com.social.user.service.persistence.jpa.mongo.document;

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
@Document("BlockingUser")
@CompoundIndexes({
        @CompoundIndex(name = "blocked_user_index", def = "{'user' : 1, 'blockUser': 1}", unique = true)
})
public class BlockingUserDocument {

    private String user;
    private String blockedUser;
    private Date createdDate;
}
