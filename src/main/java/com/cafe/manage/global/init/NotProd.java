package com.cafe.manage.global.init;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe.repository.CafeRepository;
import com.cafe.manage.domain.member.member.dto.request.JoinRequest;
import com.cafe.manage.domain.member.member.service.MemberService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Profile("!prod")
@RequiredArgsConstructor
@Configuration
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;

    private final MemberService memberService;
    private final CafeRepository cafeRepository;
    @Bean
    @Order(3)
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() throws IOException {
        memberService.join(JoinRequest.builder()
                .nickname("member")
                .password("111111")
                .build());

        Cafe cafe = Cafe.builder()
                .name("member1 test cafe")
                .member(memberService.findById(1))
                .build();

        cafeRepository.save(cafe);
    }
}
