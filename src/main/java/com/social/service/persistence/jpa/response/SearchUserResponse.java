package com.social.service.persistence.jpa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.service.persistence.jpa.dto.PostDto;
import com.social.service.persistence.jpa.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchUserResponse {

    @JsonProperty(value = "userData")
    private List<UserDto> userData;

    @JsonProperty(value = "postData")
    private List<PostDto> postData;


}
