package jaehuek.instagram.domain.user.controller;

import jaehuek.instagram.domain.user.dto.SignupRequest;
import jaehuek.instagram.domain.user.dto.UserInfo;
import jaehuek.instagram.domain.user.dto.UserUpdateRequest;
import jaehuek.instagram.domain.user.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserInfo signup(@ModelAttribute @Valid SignupRequest signupRequest) {
        if (userService.isDuplicationNickname(signupRequest.getNickname())) {
            throw new RuntimeException();
        }
        return userService.signup(signupRequest);
    }

    @PutMapping("/{userId}")
    public UserInfo update(@ModelAttribute @Valid UserUpdateRequest userUpdateRequest,
                           @PathVariable @Valid Long userId) {
        return userService.update(userUpdateRequest, userId);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @GetMapping
    public UserInfo findOne(@RequestParam(value = "userId") Long userId) {
        return userService.findOne(userId);
    }
}
