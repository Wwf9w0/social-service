package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.persistence.jpa.mongo.document.LikedPostDocument;
import com.social.service.service.persistence.jpa.mongo.repository.LikedPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikedPostMongoService {
    private final LikedPostRepository likedPostRepository;

    public void save(LikedPostDocument likedPostDocument){
        likedPostRepository.save(likedPostDocument);
    }
}
