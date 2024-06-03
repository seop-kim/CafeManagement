package com.cafe.manage.domain.cafe.cafe.dto.response;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CafeResponse {
    private Long id;
    private String name;
    private int changeCoupon;
    private long couponAmount;
    private CafeCustomerListResponse customer;

    public static CafeResponse of(Cafe cafe) {
        return CafeResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .changeCoupon(cafe.getChangeCoupon())
                .couponAmount(cafe.getCouponAmount())
                .build();
    }

    public static CafeResponse of(CafeCustomer cafeCustomer) {
        return CafeResponse.builder()
                .id(cafeCustomer.getCafe().getId())
                .name(cafeCustomer.getCafe().getName())
                .changeCoupon(cafeCustomer.getCafe().getChangeCoupon())
                .couponAmount(cafeCustomer.getCafe().getCouponAmount())
                .customer(CafeCustomerListResponse.of(cafeCustomer))
                .build();
    }
}
