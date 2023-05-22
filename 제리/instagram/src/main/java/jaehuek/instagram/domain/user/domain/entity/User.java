package jaehuek.instagram.domain.user.domain.entity;

import jaehuek.instagram.global.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String password;

    private String profileImage;

    private boolean isActive;

    @Builder
    public User(String nickname, String profileImage, Boolean isActive) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.isActive = isActive;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public void delete() {
        this.isActive = false;
    }
}


