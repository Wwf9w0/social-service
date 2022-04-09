package com.social.service.persistence.jpa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

    private String userName;
    private boolean showPostsToEveryone;
    private boolean postCommentAllowed;
}
