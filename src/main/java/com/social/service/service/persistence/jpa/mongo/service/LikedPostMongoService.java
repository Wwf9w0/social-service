package com.social.service.service.persistence.jpa.mongo.service;

import com.social.service.service.persistence.jpa.mongo.document.LikedPostDocument;
import com.social.service.service.persistence.jpa.mongo.repository.LikedPostRepository;
import com.social.service.service.persistence.jpa.response.LikedPostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikedPostMongoService {
    private final LikedPostRepository likedPostRepository;

    public void save(LikedPostDocument likedPostDocument){
        likedPostRepository.save(likedPostDocument);
    }

    public LikedPostResponse getLikedPost(String userName){
        List<LikedPostDocument> likedPostDocuments = likedPostRepository.findByUserName(userName);
        List<String> postId = new ArrayList<>();
        likedPostDocuments.forEach(likedPostDocument -> {
            postId.add(likedPostDocument.getPostId());
        });
        return LikedPostResponse.builder()
                .postId(postId)
                .build();
    }
}
