package com.cafe.manage.domain.cafe.cafe.controller;

import com.cafe.manage.domain.cafe.cafe.dto.request.CafeCreateRequest;
import com.cafe.manage.domain.cafe.cafe.dto.response.CafeListResponse;
import com.cafe.manage.domain.cafe.cafe.service.CafeService;
import com.cafe.manage.global.authentication.UserPrincipal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;

    @GetMapping
    public String getCafes(@AuthenticationPrincipal UserPrincipal user,
                           Model model) {
        List<CafeListResponse> cafes = cafeService.getCafes(user.getMember());
        model.addAttribute("cafes", cafes);
        return "domain/cafe/cafe/list";
    }

    @GetMapping("/create")
    public String getCreateForm(CafeCreateRequest cafeCreateRequest) {
        return "domain/cafe/cafe/create";
    }

    @PostMapping("/create")
    public String getCreateData(@AuthenticationPrincipal UserPrincipal user,
                                CafeCreateRequest request) {
        cafeService.createCafe(request, user.getMember());
        return "redirect:/cafe";
    }
}
