package jaehuek.instagram.domain.user.service;

import jaehuek.instagram.domain.user.domain.entity.User;
import jaehuek.instagram.domain.user.domain.repository.UserRepository;
import jaehuek.instagram.domain.user.dto.SignupRequest;
import jaehuek.instagram.domain.user.dto.UserInfo;
import jaehuek.instagram.domain.user.dto.UserUpdateRequest;
import jaehuek.instagram.domain.user.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public boolean isDuplicationNickname(String userNickname) {
        return userRepository.existsByNickname(userNickname);
    }

    public UserInfo signup(SignupRequest signupRequest) {
        User newUser = User.builder()
                .nickname(signupRequest.getNickname())
                .profileImage(signupRequest.getProfileImage().getOriginalFilename())
                .isActive(true)
                .build();
        newUser.setEncryptedPassword(signupRequest.getPassword());
        newUser = userRepository.save(newUser);

        return userMapper.UserEntityToInfo(newUser);
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User findUserByUsername(String username) {
        return userRepository.findByNickname(username).orElseThrow();
    }

    public UserInfo getUserRegisterDtoByUsername(String username) {
        return userMapper.UserEntityToInfo(findUserByUsername(username));
    }

    public UserInfo update(UserUpdateRequest userUpdateRequest, Long userId) {
        return UserInfo.builder().build();
    }

    public void delete(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow();
        foundUser.delete();
        userRepository.save(foundUser);
    }

    public UserInfo findOne(Long userId) {
        return UserInfo.builder().build();
    }
}
