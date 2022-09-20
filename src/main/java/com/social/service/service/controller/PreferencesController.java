package com.social.service.service.controller;


import com.social.service.service.persistence.jpa.entity.UserPreferencesEntity;
import com.social.service.service.persistence.jpa.request.PreferencesUpdateRequest;
import com.social.service.service.service.UserPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-preferences")
public class PreferencesController {

    private final UserPreferencesService userPreferencesService;

    @PutMapping("/update")
    public ResponseEntity<UserPreferencesEntity> update(@RequestBody PreferencesUpdateRequest request){
        return ResponseEntity.ok(userPreferencesService.updatePreferences(request));
    }

    //TODO update preferences ++
    //TODO get Preferences
}
