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
public class ListPostsRequest {

    private PostStatus postStatus;
    private int page = 0;
    private int size = 20;
}
