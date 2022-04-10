package com.social.user.service.persistence.jpa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.user.service.persistence.jpa.dto.SocialPostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchResponse implements Serializable {
    private static final long serialVersionUID = 8020568239360292639L;

    @JsonProperty(value = "page")
    private Integer page;

    @JsonProperty(value = "post")
    private List<SocialPostDto> posts;
}
