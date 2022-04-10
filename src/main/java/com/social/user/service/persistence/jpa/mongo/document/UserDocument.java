package com.social.user.service.persistence.jpa.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class UserDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String name;
    private String lastName;
    private String profilePhoto;
    @Indexed
    private Integer followingCount;
    @Indexed
    private Integer followerCount;

    private PreferencesDocument preferences;
    private boolean isWriter;
    private boolean isSuperUser;
    private int status;
    private String description;
    private Date createdDate;
}
