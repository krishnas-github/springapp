package com.mycompany.springapp.booking.dto;

import com.mycompany.springapp.booking.entity.PassengerInfo;
import com.mycompany.springapp.booking.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private PaymentInfo paymentInfo;
    private PassengerInfo passengerInfo;
}
