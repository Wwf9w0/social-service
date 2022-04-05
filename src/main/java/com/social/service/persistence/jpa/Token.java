package com.social.service.persistence.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Token {

    @Id
    private String token;

    @ManyToOne
    private UserEntity user;
}
