package com.cafe.manage.domain.member.member.entity;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @NotNull
    @Column(unique = true)
    private String nickname;

    @NotNull
    private String password;

    private String name;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private MemberRole role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Cafe> cafes = new ArrayList<>();

    public void updateName(String name) {
        this.name = name;
    }
}