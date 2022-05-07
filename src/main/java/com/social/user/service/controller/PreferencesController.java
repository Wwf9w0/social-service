package com.social.user.service.controller;


import com.social.user.service.persistence.jpa.UserPreferencesEntity;
import com.social.user.service.persistence.jpa.request.PreferencesUpdateRequest;
import com.social.user.service.service.UserPreferencesService;
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

    //TODO update preferences
    //TODO get Preferences

}
