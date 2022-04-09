package com.social.service.persistence.jpa.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.service.persistence.jpa.response.UserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticSearchService {
    private  final RestHighLevelClient client;
    private final ObjectMapper objectMapper;
    private static final String USER_INDEX = "user";
    private static final String DOC_TYPE = "doc";
    private static final String FOLLOWER_COUNT_FIELD = "followerCount";

    public void updateElasticUserForField(String userName, String value, String field){
        try {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put(field, value);
            UpdateRequest request = new UpdateRequest(USER_INDEX, userName).doc(jsonMap);
            client.update(request, RequestOptions.DEFAULT);
        }catch (Exception e){
            log.error("An error occurred while updating");
        }
    }

    @Async
    public void createNewUserIndex(UserDetail userDetail){
        try {
            String externalNo = userDetail.getExternalNo();
            ElasticUser elasticUser = ElasticUser.builder()
                    .name(userDetail.getName())
                    .userName(userDetail.getUserName())
                    .lastName(userDetail.getLastName())
                    .id(externalNo)
                    .followerCount(0)
                    .profilePhoto(userDetail.getProfilePhoto())
                    .build();

            Map userMap = objectMapper.convertValue(elasticUser, Map.class);
            IndexRequest indexRequest = new IndexRequest(USER_INDEX, externalNo)
                    .source(userMap);
            client.index(indexRequest, RequestOptions.DEFAULT);
            log.info("Created user index -> username : {}", userDetail.getUserName());
        }catch (Exception e){

        }
    }


}
