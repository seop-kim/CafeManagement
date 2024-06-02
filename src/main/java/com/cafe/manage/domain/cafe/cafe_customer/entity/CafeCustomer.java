package com.cafe.manage.domain.cafe.cafe_customer.entity;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.coupon.entity.Coupon;
import com.cafe.manage.domain.cafe.customer.entity.Customer;
import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeCustomer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
