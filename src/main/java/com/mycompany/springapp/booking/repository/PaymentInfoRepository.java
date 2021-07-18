package com.mycompany.springapp.booking.repository;

import com.mycompany.springapp.booking.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,Long> {
}
