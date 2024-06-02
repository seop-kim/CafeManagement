package com.cafe.manage.domain.cafe.customer.dto.response;

import com.cafe.manage.domain.cafe.cafe.dto.response.CafeCustomerListResponse;
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
public class CafeCustomerResponse {
    private Long id;
    private String name;
    private CafeCustomerListResponse customer;

    public static CafeCustomerResponse of(Cafe cafe, CafeCustomer cafeCustomer) {
        return CafeCustomerResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .customer(CafeCustomerListResponse.of(cafeCustomer))
                .build();
    }

    public static CafeCustomerResponse of(CafeCustomer cafeCustomer) {
        return CafeCustomerResponse.builder()
                .id(cafeCustomer.getCafe().getId())
                .name(cafeCustomer.getCafe().getName())
                .customer(CafeCustomerListResponse.of(cafeCustomer))
                .build();
    }
}
