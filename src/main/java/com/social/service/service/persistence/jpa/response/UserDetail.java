package com.social.service.service.persistence.jpa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    private String externalNo;
    private String userName;
    private String profilePhoto;
    private String name;
    private String lastName;
}
