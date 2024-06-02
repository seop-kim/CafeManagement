package com.cafe.manage.domain.cafe.cafe.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class CafeCreateRequest {
    @NotBlank(message = "카페이름은 필수 항목입니다.")
    private String name;
}
