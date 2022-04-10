package com.social.user.service.persistence.jpa.response;

import java.util.List;

public class PageResponse <T>{

    private List<T> data;
    private Integer totalElement;
    private Integer page;
    private Integer pageSize;
}
