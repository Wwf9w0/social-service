package com.social.service.service.controller;

import com.social.service.service.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping()
    public ResponseEntity<Void> register(@RequestHeader(AUTHORIZATION) String token){
        //TODO .... block
        loginService.login(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 }
