package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.persistence.jpa.dto.LikeDto;
import com.social.service.service.persistence.jpa.mongo.converter.LikeConverter;
import com.social.service.service.persistence.jpa.mongo.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeMongoService {
    private final LikeRepository likeRepository;

    public LikeDto getLikeForUserName(String userName) {
        return LikeConverter.toDto(likeRepository.findByUserName(userName));
    }
}
