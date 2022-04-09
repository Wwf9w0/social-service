package com.social.service.persistence.jpa.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class UserEntity {

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

    private PreferencesEntity preferences;
    private boolean isWriter;
    private boolean isSuperUser;
    private int status;
    private String description;
    private Date createdDate;
}
