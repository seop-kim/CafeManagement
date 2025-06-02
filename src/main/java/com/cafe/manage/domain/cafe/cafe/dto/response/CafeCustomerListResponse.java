package com.cafe.manage.domain.cafe.cafe.dto.response;

import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import com.cafe.manage.domain.cafe.coupon.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CafeCustomerListResponse {
    private Long id;
    private Long cafeCustomerId;
    private String phone;

    public static CafeCustomerListResponse of(CafeCustomer cafeCustomer) {
        return CafeCustomerListResponse.builder()
                .id(cafeCustomer.getCustomer().getId())
                .cafeCustomerId(cafeCustomer.getId())
                .phone(cafeCustomer.getCustomer().getPhone())
                .build();
    }
}
