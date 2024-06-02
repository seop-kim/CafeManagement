package com.cafe.manage.global.init;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe.repository.CafeRepository;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import com.cafe.manage.domain.cafe.cafe_customer.repository.CafeCustomerRepository;
import com.cafe.manage.domain.cafe.coupon.entity.Coupon;
import com.cafe.manage.domain.cafe.coupon.repository.CouponRepository;
import com.cafe.manage.domain.cafe.customer.entity.Customer;
import com.cafe.manage.domain.cafe.customer.repository.CustomerRepository;
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
    private final CustomerRepository customerRepository;
    private final CafeCustomerRepository cafeCustomerRepository;
    private final CouponRepository couponRepository;
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
                .changeCoupon(10)
                .couponAmount(3000)
                .build();

        cafeRepository.save(cafe);

        Customer customer = Customer.builder()
                .phone("01041932693")
                .build();

        customerRepository.save(customer);

        Coupon coupon1 = Coupon.builder().build();
        couponRepository.save(coupon1);

        CafeCustomer cafeCustomer = CafeCustomer.builder()
                .customer(customer)
                .cafe(cafe)
                .coupon(coupon1)
                .build();

        cafeCustomerRepository.save(cafeCustomer);

        Cafe cafe2 = Cafe.builder()
                .name("member1 test cafe2")
                .member(memberService.findById(1))
                .changeCoupon(9)
                .couponAmount(3000)
                .build();

        cafeRepository.save(cafe2);

        Coupon coupon2 = Coupon.builder().build();
        couponRepository.save(coupon2);

        CafeCustomer cafeCustomer2 = CafeCustomer.builder()
                .customer(customer)
                .cafe(cafe2)
                .coupon(coupon2)
                .build();


        cafeCustomerRepository.save(cafeCustomer2);
    }
}
