package com.social.service.persistence.jpa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {

    @NotNull(message ="hashTag connot be null " )
    private String hashTag;
    private Integer page = 0;
    private Integer size = 10;
}
