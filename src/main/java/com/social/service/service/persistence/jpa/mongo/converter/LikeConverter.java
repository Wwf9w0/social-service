package com.social.service.service.persistence.jpa.mongo.converter;

import com.social.service.service.persistence.jpa.dto.LikeDto;
import com.social.service.service.persistence.jpa.mongo.document.LikeDocument;

public class LikeConverter {

    public static LikeDto toDto(LikeDocument likeDocument){
        return LikeDto.builder()
                .userName(likeDocument.getUserName())
                .build();
    }
}
