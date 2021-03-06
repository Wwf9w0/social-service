package com.social.user.service.persistence.jpa;

import com.social.user.service.converter.UserPreferencesConverter;
import com.social.user.service.persistence.jpa.repository.UserPreferencesRepository;
import com.social.user.service.persistence.jpa.request.PreferencesUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserPreferencesPersistenceService {

    private final UserPreferencesRepository userPreferencesRepository;
    private final UserPreferencesConverter converter;

    public UserPreferencesEntity updatePreferences(PreferencesUpdateRequest request){

        UserPreferencesEntity userPreferences = converter.toEntity(request);
        UserPreferencesEntity getUser = userPreferencesRepository.findById(userPreferences.getId()).orElse(null);
        if (Objects.nonNull(getUser)){
            userPreferencesRepository.save(userPreferences);
        }
        return userPreferences;
    }

}
