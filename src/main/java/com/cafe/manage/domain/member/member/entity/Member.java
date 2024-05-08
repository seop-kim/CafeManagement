package com.cafe.manage.domain.member.member.entity;

import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NotFound;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @NotFound
    @Column(unique = true)
    private String nickname;

    @NotFound
    private String password;

    @NotFound
    private String name;

    @NotFound
    @Column(unique = true)
    private Long phoneNumber;

    @NotFound
    @Enumerated(value = EnumType.STRING)
    private MemberRole role;
}