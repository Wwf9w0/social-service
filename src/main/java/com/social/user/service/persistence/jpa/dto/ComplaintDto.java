package com.social.user.service.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComplaintDto {

    private String userName;
    private String reason;

}
