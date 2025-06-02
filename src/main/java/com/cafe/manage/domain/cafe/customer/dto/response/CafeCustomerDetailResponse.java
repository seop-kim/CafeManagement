package com.cafe.manage.domain.cafe.customer.dto.response;

import com.cafe.manage.domain.cafe.cafe.dto.response.CafeCustomerListResponse;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CafeCustomerDetailResponse {
    private Long id;
    private String cafeName;
    private Long cafeCustomerId;
    private String phone;
    private Long couponCount;
    private Long stampCount;

    public static CafeCustomerDetailResponse of(CafeCustomer cafeCustomer) {
        return CafeCustomerDetailResponse.builder()
                .id(cafeCustomer.getCustomer().getId())
                .cafeName(cafeCustomer.getCafe().getName())
                .cafeCustomerId(cafeCustomer.getId())
                .phone(cafeCustomer.getCustomer().getPhone())
                .couponCount(cafeCustomer.getCoupon().getCouponCount())
                .stampCount(cafeCustomer.getCoupon().getStampCount())
                .build();
    }
}
