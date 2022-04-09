package com.social.service.persistence.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriterDto {

    private String id;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "pp")
    private String profilePhoto;
    @JsonProperty(value = "frc")
    private Integer followerCount;
    @JsonProperty(value = "flc")
    private Integer followingCount;
    @JsonProperty(value = "isF")
    private Boolean isFollowing;
    @JsonProperty(value = "ttpc")
    private Long totalPostCount;
    @JsonProperty(value = "dsc")
    private String description;

}
