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
public class CafeCustomerSearchResponse {
    private Long id;
    private String name;
    private CafeCustomerListResponse customer;

    public static CafeCustomerSearchResponse of(Cafe cafe, CafeCustomer cafeCustomer) {
        return CafeCustomerSearchResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .customer(CafeCustomerListResponse.of(cafeCustomer))
                .build();
    }

    public static CafeCustomerSearchResponse of(CafeCustomer cafeCustomer) {
        return CafeCustomerSearchResponse.builder()
                .id(cafeCustomer.getCafe().getId())
                .name(cafeCustomer.getCafe().getName())
                .customer(CafeCustomerListResponse.of(cafeCustomer))
                .build();
    }
}
