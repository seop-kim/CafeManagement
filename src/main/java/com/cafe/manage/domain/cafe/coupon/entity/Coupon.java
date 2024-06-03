package com.cafe.manage.domain.cafe.coupon.entity;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import com.cafe.manage.domain.cafe.customer.entity.Customer;
import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends BaseEntity {
    @OneToOne(mappedBy = "coupon")
    private CafeCustomer cafeCustomer;

    @Builder.Default
    private Long couponCount = 0L;

    @Builder.Default
    private Long stampCount = 0L;

    public void addStamp(Long stampCount) {
        if (stampCount == 0) {
            return;
        }

        this.stampCount += stampCount;
        updateStamp();
    }

    private void updateStamp() {
        int changeStampToCouponCount = this.cafeCustomer.getCafe().getChangeCoupon();

        while (this.stampCount >= changeStampToCouponCount) {
            this.stampCount -= changeStampToCouponCount;
            this.couponCount += 1;
        }
    }

    public void subtractCoupon(int couponCount) {
        this.couponCount -= couponCount;
    }
}
