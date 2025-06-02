package com.cafe.manage.domain.cafe.cafe.dto.response;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CafeListResponse {
    private long id;
    private String name;
    private long customerCount;

    public static CafeListResponse of(Cafe cafe, long customerCount) {
        return CafeListResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .customerCount(customerCount)
                .build();
    }
}
