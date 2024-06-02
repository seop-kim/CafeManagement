package com.cafe.manage.domain.cafe.customer.service;

import com.cafe.manage.domain.cafe.cafe.dto.request.CafeCustomerRequest;
import com.cafe.manage.domain.cafe.cafe.dto.response.CafeResponse;
import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe.repository.CafeRepository;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import com.cafe.manage.domain.cafe.cafe_customer.repository.CafeCustomerRepository;
import com.cafe.manage.domain.cafe.coupon.entity.Coupon;
import com.cafe.manage.domain.cafe.coupon.repository.CouponRepository;
import com.cafe.manage.domain.cafe.customer.entity.Customer;
import com.cafe.manage.domain.cafe.customer.repository.CustomerRepository;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CafeRepository cafeRepository;
    private final CafeCustomerRepository cafeCustomerRepository;
    private final CouponRepository couponRepository;

    @Transactional
    public CafeResponse searchCustomer(CafeCustomerRequest cafeCustomerRequest) {
        phoneValidate(cafeCustomerRequest.getPhone());

        Cafe cafe = cafeRepository.findById(cafeCustomerRequest.getCafeId())
                .orElseThrow(() -> new IllegalArgumentException("no cafe"));

        CafeCustomer cafeCustomer = cafeCustomerRepository.findByCafeAndCustomer_Phone(cafe,
                        cafeCustomerRequest.getPhone())
                .orElseGet(() -> {
                    Customer customer = getCustomer(cafeCustomerRequest.getPhone());
                    Coupon coupon = getCoupon();

                    CafeCustomer newCafeCustomer = CafeCustomer.builder()
                            .cafe(cafe)
                            .customer(customer)
                            .coupon(coupon)
                            .build();
                    cafeCustomerRepository.save(newCafeCustomer);

                    return newCafeCustomer;
                });

        return CafeResponse.of(cafeCustomer);
    }

    private Customer getCustomer(String phone) {
        Customer customer = customerRepository.findByPhone(phone).orElseGet(() ->
                Customer.builder()
                .phone(phone)
                .build());

        customerRepository.save(customer);
        return customer;
    }

    private Coupon getCoupon() {
        Coupon coupon = Coupon.builder().build();
        couponRepository.save(coupon);
        return coupon;
    }

    private void phoneValidate(String phone) {
        String pattern = "^\\d{3}\\d{3,4}\\d{4}$";
        if (!Pattern.matches(pattern, phone)) {
            throw new IllegalArgumentException("Configuration not allowed");
        }
    }
}
