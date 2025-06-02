package com.cafe.manage.domain.cafe.coupon.repository;

import com.cafe.manage.domain.cafe.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
