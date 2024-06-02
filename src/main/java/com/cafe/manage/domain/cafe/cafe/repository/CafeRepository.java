package com.cafe.manage.domain.cafe.cafe.repository;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.member.member.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Optional<List<Cafe>> findByMember(Member member);
}
