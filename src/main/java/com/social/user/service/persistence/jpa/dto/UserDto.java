package com.social.user.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.user.service.persistence.jpa.mongo.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {


    private String id;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "pp")
    private String profilePhoto;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "lastName")
    private String lastName;
    @JsonProperty(value = "flc")
    private Integer followingCount;
    @JsonProperty(value = "frc")
    private Integer followerCount;
    @JsonProperty(value = "pre")
    private PreferencesDto preferences;
    @JsonProperty(value = "sDate")
    private Double successDate;
    @JsonProperty(value = "dsc")
    private String description;
    @JsonProperty(value = "isF")
    private Boolean isFollowing;
    @JsonProperty(value = "writer")
    private boolean writer;
    @JsonProperty(value = "status")
    private PostStatus status;
    @JsonProperty(value = "isBlocked")
    private Boolean isBlocked;
    @JsonProperty(value = "isNotifier")
    private Boolean isNotifier;

}
