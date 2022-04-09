package com.social.service.service;

import com.social.service.persistence.jpa.dto.UserDto;
import com.social.service.persistence.jpa.response.UserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;

    public void login(String token){
      userService.getUserByDetail(token);
    }

}
