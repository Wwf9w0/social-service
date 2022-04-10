package com.social.user.service.persistence.jpa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.social.user.service.persistence.jpa.dto.ErrorDto;
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
public class BaseResponse<T> {

    private String message;
    private boolean success;
    private T data;
    private List<ErrorDto> error;
}
