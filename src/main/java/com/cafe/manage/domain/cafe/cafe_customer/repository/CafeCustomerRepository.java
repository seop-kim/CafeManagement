package com.cafe.manage.domain.cafe.cafe_customer.repository;

import com.cafe.manage.domain.cafe.cafe.entity.Cafe;
import com.cafe.manage.domain.cafe.cafe_customer.entity.CafeCustomer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeCustomerRepository extends JpaRepository<CafeCustomer, Long> {
    long countByCafe(Cafe cafe);

    List<CafeCustomer> findByCafe(Cafe cafe);

    Optional<CafeCustomer> findByCafeAndCustomer_Phone(Cafe cafeId, String phone);
}
