package com.social.service.service.persistence.jpa.repository;

import com.social.service.service.persistence.jpa.entity.UserPreferencesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferencesEntity, Long> {
}
