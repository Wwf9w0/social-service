package com.social.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.service.persistence.jpa.mongo.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialPostDto implements Serializable {
    private static final long serialVersionUID = -876001240736124588L;

    private String id;
    @JsonProperty(value = "user")
    private PostUserDto user;
    @JsonProperty(value = "fdsd")
    private Boolean followToSeeDetail;
    @JsonProperty(value = "postCount")
    private Integer postCount;
    @JsonProperty(value = "likeCount")
    private Integer likeCount;
    @JsonProperty(value = "commentCount")
    private Integer commentCount;
    @JsonProperty(value = "postType")
    private String postType;
    @JsonProperty(value = "shareDate")
    private Long shareDate;
    @JsonProperty(value = "comma")
    private Boolean commentable;
    @JsonProperty(value = "status")
    private PostStatus status;
    @JsonProperty(value = "isL")
    private boolean isLiked;
    @JsonProperty(value = "desc")
    private String description;









}
