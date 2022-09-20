package com.social.service.service.converter;

import com.social.service.service.persistence.jpa.entity.UserPreferencesEntity;
import com.social.service.service.persistence.jpa.request.PreferencesUpdateRequest;

public class UserPreferencesConverter {

    public static UserPreferencesEntity toEntity(PreferencesUpdateRequest request) {

        return UserPreferencesEntity.builder()
                .sharePost(request.getShowPostsToEveryone())
                .shareUserProfile(request.getProfileOpen())
                .sharePostInfo(request.getPostCommentAllowed())
                .build();
    }
}
