package com.cafe.manage.domain.cafe.customer.dto.request;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CafeCustomerStampRequest {
    private Long cafeCustomerId;
    private Long addStampCount;
    private List<String> selectedCouponCount = new ArrayList<>();
}
