package com.social.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreferencesDto {

    @JsonProperty(value = "po")
    private boolean profileOpen;
    @JsonProperty(value = "sd")
    private boolean showPostsToEveryone;
    @JsonProperty(value = "pca")
    private boolean postCommentAllowed;
    @JsonProperty(value = "sun")
    private boolean showUserName;


}
