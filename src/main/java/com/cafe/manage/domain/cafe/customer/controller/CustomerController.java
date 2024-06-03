package com.cafe.manage.domain.cafe.customer.controller;

import com.cafe.manage.domain.cafe.cafe.dto.request.CafeCustomerRequest;
import com.cafe.manage.domain.cafe.cafe.dto.response.CafeResponse;
import com.cafe.manage.domain.cafe.customer.dto.request.CafeCustomerStampRequest;
import com.cafe.manage.domain.cafe.customer.dto.response.CafeCustomerDetailResponse;
import com.cafe.manage.domain.cafe.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public String getCustomer(CafeCustomerRequest cafeCustomerRequest,
                              Model model) {
        CafeResponse cafe = customerService.searchCustomer(cafeCustomerRequest);
        model.addAttribute("cafe", cafe);
        return "domain/cafe/cafe/detail";
    }

    @GetMapping("/{id}")
    public String getCustomerInfo(@PathVariable Long id,
                                  Model model,
                                  CafeCustomerStampRequest cafeCustomerStampRequest) {
        CafeCustomerDetailResponse cafeCustomer = customerService.getCafeCustomer(id);
        model.addAttribute("customer", cafeCustomer);
        return "domain/cafe/customer/detail";
    }

    @PostMapping("/redeem")
    public String getCustomerRedeem(CafeCustomerStampRequest cafeCustomerStampRequest,
                                    Model model) {
        System.out.println("[cafeCustomerStampRequest]");
        System.out.println("id : " + cafeCustomerStampRequest.getCafeCustomerId());
        System.out.println("stamp : " + cafeCustomerStampRequest.getAddStampCount());
        System.out.println("coupon : " + cafeCustomerStampRequest.getSelectedCouponCount().size());
        CafeCustomerDetailResponse cafeCustomer = customerService.cafeCustomerRedeem(cafeCustomerStampRequest);
        model.addAttribute("customer", cafeCustomer);
        return "domain/cafe/customer/detail";
    }
}
