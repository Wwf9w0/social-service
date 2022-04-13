package com.social.user.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostUserDto implements Serializable {
    private static final long serialVersionUID = 2314412936300525519L;

    private String id;
    @JsonProperty(value = "isF")
    private Boolean isFollowing;
    @JsonProperty(value = "username")
    private String userName;
    @JsonProperty(value = "pp")
    private String profilePhotoUrl;
    @JsonProperty(value = "scte")
    private Boolean showPostToEveryone;
    @JsonProperty(value = "cca")
    private Boolean postCommentAllowed;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "lastname")
    private String lastName;
    @JsonProperty(value = "frc")
    private Integer followerCount;
    @JsonProperty(value = "flc")
    private Integer followingCount;
    @JsonProperty(value = "tpc")
    private Integer totalPostCount;
    @JsonProperty(value = "sDate")
    private Double successDate;
}
