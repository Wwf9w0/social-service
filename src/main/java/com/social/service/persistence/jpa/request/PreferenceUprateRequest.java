package com.social.service.persistence.jpa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceUprateRequest {
    private Boolean profileOpen;
    private Boolean showPostsToEveryone;
    private Boolean postCommentAllowed;
    private Boolean showUserName;
}
