package com.social.service.service.persistence.jpa.mongo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum PostStatus {

    SHARE(1),
    CANCELLED(2),
    DELETED(3);

    private int status;

    public static PostStatus fromStatus(int status){
        for (PostStatus postStatus : PostStatus.values()){
            if (Objects.equals(postStatus.getStatus(), status)){
                return postStatus;
            }
        }
        throw new RuntimeException("Unknown status : " + status);
    }
}
