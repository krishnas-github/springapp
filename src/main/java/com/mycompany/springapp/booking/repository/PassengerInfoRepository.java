package com.mycompany.springapp.booking.repository;

import com.mycompany.springapp.booking.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,String> {
}
