package com.social.service.service.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommentComplaintDto {

    private String id;
    private String postId;
    private String commentId;
    private String answerId;
    private String comment;
    private Long date;
    private String commenterId;
    private Long commentDate;
    private List<ComplaintDto> complaints;
}
