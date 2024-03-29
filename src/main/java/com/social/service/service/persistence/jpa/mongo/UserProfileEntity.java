package com.social.service.service.persistence.jpa.mongo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user_profile")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String nickName;
    @Column
    private String email;
    @Column
    private Date birthDate;
    @Column
    private Integer gender;
    @Column
    private String profilePhoto;
    @Column
    private Boolean isUserNameConfirmed;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
}
