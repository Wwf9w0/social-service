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
@Document("Notifier")
@CompoundIndexes({
        @CompoundIndex(name = "notification_index", def = "{'user' :1, 'notifier': 1}", unique = true)
})
public class NotifierDocument {

    private String user;
    private String notifier;
    private Date createdDate;
}
