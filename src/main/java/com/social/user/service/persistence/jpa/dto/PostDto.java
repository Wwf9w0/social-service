package com.social.user.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private Long id;
    private String hashTag;
    private String userName;
}
