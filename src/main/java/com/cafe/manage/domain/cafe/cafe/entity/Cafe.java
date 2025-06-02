package com.cafe.manage.domain.cafe.cafe.entity;

import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import com.cafe.manage.domain.member.member.entity.Member;
import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Cafe extends BaseEntity {
    @Comment("카페 이름")
    private String name;

    @Comment("카페 점주")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Comment("쿠폰 적립 기준")
    private int changeCoupon;

    @Comment("쿠폰 할인 금액")
    private long couponAmount;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL)
    private List<CafeCustomer> cafeCustomers = new ArrayList<>();
}
