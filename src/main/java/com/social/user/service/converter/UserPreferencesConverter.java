package com.social.user.service.converter;

import com.social.user.service.persistence.jpa.UserPreferencesEntity;
import com.social.user.service.persistence.jpa.request.PreferencesUpdateRequest;

public class UserPreferencesConverter {

    public static UserPreferencesEntity toEntity(PreferencesUpdateRequest request) {

        return UserPreferencesEntity.builder()
                .sharePost(request.getShowPostsToEveryone())
                .shareUserProfile(request.getProfileOpen())
                .sharePostInfo(request.getPostCommentAllowed())
                .build();
    }
}
