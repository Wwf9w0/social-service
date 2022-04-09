package com.social.service.persistence.jpa.mongo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum UserStatus {

    ACTIVE(1),
    BLOCKED(2);


    private int status;

    public static PostStatus fromValue(int value){
        for (PostStatus postStatus : PostStatus.values()){
            if (Objects.equals(postStatus.getStatus(), value)){
                return postStatus;
            }
        }
        throw new RuntimeException("Unknown status : " + value);
    }

}
