package com.social.service.service.persistence.jpa.mongo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostFilterType {
    SHARE_DATE(1, "shareDate"),
    FOLLOWER_COUNT(2, "followerCount"),
    COMMENT_COUNT(3, "commentCount");

    private int value;
    private String description;
}
