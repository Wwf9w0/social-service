package com.social.service.service.service;

import com.social.service.service.persistence.jpa.mongo.document.LikedPostDocument;
import com.social.service.service.persistence.jpa.mongo.service.LikedPostMongoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikedPostService {

    private final LikedPostMongoService likedPostMongoService;

    public void save(LikedPostDocument likedPostDocument) {
        likedPostMongoService.save(likedPostDocument);
    }
}
