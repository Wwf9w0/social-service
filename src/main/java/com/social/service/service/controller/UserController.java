package com.social.service.service.controller;


import com.social.service.service.service.UserService;
import com.social.service.service.persistence.jpa.mongo.UserProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/detail")
    public ResponseEntity<UserProfileEntity> getUserDetail(@RequestHeader(AUTHORIZATION) String token){
        return ResponseEntity.ok(userService.getUser(token));
    }
}



//TODO Post-Service

/**
PostCommentController
-getcomments id
-postComment
-postAnswer
-deletecomment
-deleteanswer
-complaincomment
-
*
* */



/**
PostController
create-delete-update-getting
* */



/**
* PostLikeController
* id like
* id dislike
* */


/**Post Search Controller
 * List Post of hashtag
 * List post of users
 * list following users posts
 */


/**
 *
 * PostDetailController
 * getPost
 * getPostDetail
 * getFollowingUserPosts
 * getTopics
 * */



/**Public Post Controller
 * get Most posts
 * get reqular user posts
 * get topic posts
 *
 * */


/**UserProfileController
 * getProfilePosts
 * getUserPosts
 * pin posts
 * unpin posts
 * delete posts
 * disable post comments
 * enable post comments
 *
 * */