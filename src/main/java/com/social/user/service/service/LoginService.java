package com.social.user.service.service;

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
