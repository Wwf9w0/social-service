package com.social.service.service;

import com.social.service.persistence.jpa.dto.UserDto;
import com.social.service.persistence.jpa.elasticsearch.ElasticSearchService;
import com.social.service.persistence.jpa.mongo.service.FollowerMongoService;
import com.social.service.persistence.jpa.mongo.service.NotifierMongoService;
import com.social.service.persistence.jpa.response.UserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class FollowService {

    private final UserService userService;
    private final FollowerMongoService followerMongoService;
    private final ElasticSearchService elasticSearchService;
    private final NotifierMongoService notifierMongoService;

    @Transactional
    public void follow(String token, String followUserName) {
        String userName = userService.getUserName(token);

        try {
            userService.assertUserExisted(userName.toString());
            followerMongoService.createFollower(userName, followUserName);
            userService.incFollowerCount(userName);
            userService.incFollowingCount(userName);

        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    @Transactional
    public void unFollow(String token, String followingUserName) {
        String userName = userService.getUserName(token);
        long deleteCount = followerMongoService.deleteFollowing(userName, followingUserName);
        if (deleteCount < 1) {
            return;
        }

        userService.decreaseFollowerCount(followingUserName);
        userService.decreaseFollowingCount(userName);
        elasticSearchService.updateFollowerCount(followingUserName, -1);

        removeNofilter(userName, followingUserName);

    }

    public List<UserDto> getFollowersOfUser(String token, String userName, Integer page, Integer size){
        UserDetail userDetail = userService.getUserByDetail(token);
        UserDto userDto = userService.getUserBasicInfo(userDetail.getUserName());
        List<String> followingIds = followerMongoService.getFollowingIds(userDto.getUserName(), page, size);
        return getFollowersForUserName(userName, followingIds, page, size);

    }

    private List<UserDto> getFollowersForUserName(String userName, List<String> followinmgIds, Integer page, Integer size){
        List<String> userFollowings = followerMongoService.getFollowingIds(userName, page, size);
        return constructUserDtoListFollowings(userName, userFollowings,followinmgIds);
    }

    private List<UserDto> constructUserDtoListFollowings(String userName, List<String> users, List<String> followings){
        List<UserDto> collect = users.stream()
                .map(this::getUserBasicInfo)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return collect;
    }

    private UserDto getUserBasicInfo(String userName){
        try {
            return userService.getUserBasicInfo(userName);
        }catch (Exception e){
            return null;
        }
    }

    private void removeNofilter(String userName, String followingUserName) {
        try {
            notifierMongoService.deleteNotifier(userName, followingUserName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public List<UserDto> getFollowings(String token, Integer page, Integer size){
        String userName = userService.getUserName(token);
        List<String> followingIds = followerMongoService.getFollowingIds(userName, page, size);
        List<UserDto> followingUsers = followingIds.stream()
                .map(this::getUserBasicInfo)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        List<String> notifiers = notifierMongoService.getNotifiersOfUser(userName);

        followingUsers.forEach(userDto -> {
            userDto.setIsFollowing(true);
        });
        return followingUsers;
    }



    public List<UserDto> getFollowingsOfUser(String token, String userName, Integer page, Integer size){
        UserDetail userDetail = userService.getUserByDetail(token);
        UserDto userDto = userService.getUserBasicInfo(userDetail.getUserName());
        List<String> followingIds = followerMongoService.getFollowingIds(userDto.getUserName(), page, size);
        return getFollowersForUserName(userName, followingIds, page, size);

    }


}
