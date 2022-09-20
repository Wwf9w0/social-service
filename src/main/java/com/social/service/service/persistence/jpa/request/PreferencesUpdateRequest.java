package com.social.service.service.persistence.jpa.request;

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
public class PreferencesUpdateRequest {
    private Boolean profileOpen;
    private Boolean showPostsToEveryone;
    private Boolean postCommentAllowed;
    private Boolean showUserName;
}
