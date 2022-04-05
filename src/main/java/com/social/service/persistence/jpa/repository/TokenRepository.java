package com.social.service.persistence.jpa.repository;

import com.social.service.persistence.jpa.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
