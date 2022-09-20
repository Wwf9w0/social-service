package com.social.service.service.persistence.jpa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {

    private String hashTag;
    private Integer page = 0;
    private Integer size = 10;
}
