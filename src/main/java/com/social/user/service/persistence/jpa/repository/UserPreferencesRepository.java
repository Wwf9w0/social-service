package com.social.user.service.persistence.jpa.repository;

import com.social.user.service.persistence.jpa.UserPreferencesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferencesEntity, Long> {
}
