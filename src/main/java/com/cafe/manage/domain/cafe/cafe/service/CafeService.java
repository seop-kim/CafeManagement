package com.cafe.manage.domain.cafe.cafe.service;

import com.cafe.manage.domain.cafe.cafe.dto.request.CafeCreateRequest;
import com.cafe.manage.domain.cafe.cafe.dto.response.CafeListResponse;
import com.cafe.manage.domain.cafe.cafe.dto.response.CafeResponse;
import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe.repository.CafeRepository;
import com.cafe.manage.domain.cafe.cafe_customer.repository.CafeCustomerRepository;
import com.cafe.manage.domain.member.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CafeService {
    private final CafeRepository cafeRepository;
    private final CafeCustomerRepository cafeCustomerRepository;

    public List<CafeListResponse> getCafes(Member member) {
        List<Cafe> cafes = cafeRepository.findByMember(member).orElseGet(ArrayList::new);
        List<CafeListResponse> response = new ArrayList<>();

        for (Cafe cafe : cafes) {
            long customerCount = cafeCustomerRepository.countByCafe(cafe);
            response.add(CafeListResponse.of(cafe, customerCount));
        }
        return response;
        /*
        jpa in 절 성능 저하로 인하여 미사용, 반대로 위 방법은 가지고 있는 카페 수 만큼 DB에 접근을 한다. 뭐가 좋을까.
        return cafes.stream().map(CafeListResponse::of).collect(Collectors.toList());
         */
    }

    public CafeResponse getCafe(Member member, Long cafeId) {
        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new IllegalArgumentException("cafe is null"));

        getCafeValidate(cafe, member);
        return CafeResponse.of(cafe);
    }

    @Transactional
    public void createCafe(CafeCreateRequest request, Member member) {
        createValidate(request);
        Cafe cafe = Cafe.builder()
                .member(member)
                .name(request.getName())
                .couponAmount(request.getCouponAmount())
                .changeCoupon(request.getChangeCoupon())
                .build();

        cafeRepository.save(cafe);
    }

    private void createValidate(CafeCreateRequest request) {
        if (request.getName().isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
    }

    private void getCafeValidate(Cafe cafe, Member member) {
        if (!cafe.getMember().equals(member)) {
            throw new IllegalStateException("no atuthentification");
        }
    }
}
