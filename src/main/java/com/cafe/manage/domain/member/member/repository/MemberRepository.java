package com.cafe.manage.domain.member.member.repository;

import com.cafe.manage.domain.member.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNickname(String email);
}