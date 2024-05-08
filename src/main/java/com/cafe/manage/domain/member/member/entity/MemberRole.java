package com.cafe.manage.domain.member.member.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
    MEMBER("MEMBER"),
    ;

    private final String value;

    MemberRole(String value) {
        this.value = value;
    }
}
