package com.cafe.manage.domain.member.member.controller;

import com.cafe.manage.domain.member.member.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/login")
    public String loginForm(LoginRequest loginRequest) {
        return "domain/member/member/login";
    }
}
