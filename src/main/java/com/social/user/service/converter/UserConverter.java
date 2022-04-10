package com.social.user.service.converter;

import com.social.user.service.persistence.jpa.dto.PreferencesDto;
import com.social.user.service.persistence.jpa.dto.UserDto;
import com.social.user.service.persistence.jpa.mongo.document.PreferencesDocument;
import com.social.user.service.persistence.jpa.mongo.document.UserDocument;
import com.social.user.service.persistence.jpa.mongo.enums.UserStatus;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class UserConverter {

    public static UserDto toUserDto(UserDocument userDocument){
        String name = capitalize(userDocument.getName());
        String lastName = capitalize(userDocument.getLastName());
        String userName = userDocument.getPreferences().isShowUserName()
                ? userDocument.getUserName()
                : name + StringUtils.SPACE + lastName;
        return UserDto.builder()
                .userName(userName)
                .profilePhoto(userDocument.getProfilePhoto())
                .followerCount(userDocument.getFollowerCount())
                .followingCount(userDocument.getFollowingCount())
                .id(userDocument.getId())
                .status(UserStatus.fromValue(userDocument.getStatus()))
                .preferences(getPreferences(userDocument.getPreferences()))
                .build();
    }

    private static PreferencesDto getPreferences(PreferencesDocument preferencesDocument){
        return PreferencesDto.builder()
                .showUserName(preferencesDocument.isShowUserName())
                .profileOpen(preferencesDocument.isProfileOpen())
                .showPostsToEveryone(preferencesDocument.isPostViewAllowedForEveryone())
                .postCommentAllowed(preferencesDocument.isPostCommentAllowed())
                .build();
    }


    private static String capitalize(String text){
        StringBuilder capitalizeD = new StringBuilder(StringUtils.EMPTY);
        String[] split = text.split(StringUtils.SPACE);
        Locale trLocale = new Locale("tr");
        for (String s : split){
            capitalizeD.append(StringUtils.capitalize(s.toLowerCase(trLocale)))
                    .append(StringUtils.SPACE);
        }
        return capitalizeD.toString().trim();
    }

}
