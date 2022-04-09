package com.social.service.persistence.jpa.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticPost {

    private Long id;
    private String name;
    private Long date;
    private Integer postStatus;
}
