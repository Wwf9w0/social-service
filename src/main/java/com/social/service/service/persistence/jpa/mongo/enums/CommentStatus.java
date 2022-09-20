package com.social.service.service.persistence.jpa.mongo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentStatus {

    ACTIVE(1),
    REMOWED_BY_USER(2);

    private int status;
}
