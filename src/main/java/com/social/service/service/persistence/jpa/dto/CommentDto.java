package com.social.service.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {

    private String userName;
    private String comment;
    private Long createdDate;
}
