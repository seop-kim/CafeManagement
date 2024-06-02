package com.cafe.manage.domain.cafe.coupon.entity;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.customer.entity.Customer;
import com.cafe.manage.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
public class Coupon extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private int couponCount;

    private int stampCount;
}