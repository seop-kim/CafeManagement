package com.cafe.manage.domain.cafe.cafe_customer.repository;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeCustomerRepository extends JpaRepository<CafeCustomer, Long> {
    long countByCafe(Cafe cafe);
}
