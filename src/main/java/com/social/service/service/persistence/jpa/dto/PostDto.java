package com.social.service.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private String id;
    private String hashTag;
    private String userName;
    private Integer status;
    private Boolean pinned;
    private LocalDateTime shareDate;
    private Boolean commentable;
    private String description;
}
