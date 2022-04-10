package com.social.user.service.persistence.jpa.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticUser {

    private String id;
    private String name;
    private String lastName;
    private String userName;
    private Integer followerCount;
    private String profilePhoto;
}
