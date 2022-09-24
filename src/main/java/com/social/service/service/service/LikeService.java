package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.service.LikeMongoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {

    private final LikeMongoService likeMongoService;

    public String getLikedPostForUser(String userName) {
        return likeMongoService.getLikeForUserName(userName);
    }
}
