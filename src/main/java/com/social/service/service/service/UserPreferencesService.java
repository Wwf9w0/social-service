package com.social.service.service.service;

import com.social.service.service.persistence.jpa.dto.PreferencesDto;
import com.social.service.service.persistence.jpa.entity.UserPreferencesEntity;
import com.social.service.service.persistence.jpa.entity.UserPreferencesPersistenceService;
import com.social.service.service.persistence.jpa.mongo.service.UserMongoService;
import com.social.service.service.persistence.jpa.request.PreferencesUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPreferencesService {

    private final UserPreferencesPersistenceService preferencesPersistenceService;
    private final SocialUserService socialUserService;


    public UserPreferencesEntity updatePreferences(PreferencesUpdateRequest request){
        return preferencesPersistenceService.updatePreferences(request);
    }

    public PreferencesDto getPreferences(Long preferencesId){
        // wait new endpoint for user
        return null;
    }


}
