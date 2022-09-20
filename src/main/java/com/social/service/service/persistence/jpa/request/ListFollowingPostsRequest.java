package com.social.service.service.persistence.jpa.request;

import com.social.service.service.persistence.jpa.mongo.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListFollowingPostsRequest {

    private String followerUserName;
    private PostStatus postStatus;
}
