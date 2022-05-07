package com.social.user.service.service;

import com.social.user.service.persistence.jpa.UserPreferencesEntity;
import com.social.user.service.persistence.jpa.UserPreferencesPersistenceService;
import com.social.user.service.persistence.jpa.request.PreferencesUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPreferencesService {

    private final UserPreferencesPersistenceService preferencesPersistenceService;

    public UserPreferencesEntity updatePreferences(PreferencesUpdateRequest request){
        return preferencesPersistenceService.updatePreferences(request);
    }
}
