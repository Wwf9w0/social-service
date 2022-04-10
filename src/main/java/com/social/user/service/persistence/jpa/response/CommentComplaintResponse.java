package com.social.user.service.persistence.jpa.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.social.user.service.persistence.jpa.dto.CommentComplaintDto;
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
public class CommentComplaintResponse {

    private List<CommentComplaintDto> commentComplaints;
}
