package com.social.service.service.persistence.jpa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponse {

    private String id;
    private String name;
    private String userName;
    private String photoUrl;
    private String lastName;
}
