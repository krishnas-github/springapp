package com.mycompany.springapp.booking.service;

import com.mycompany.springapp.booking.dto.BookingRequest;
import com.mycompany.springapp.booking.dto.BookingResponse;

public interface BookingService {

    public BookingResponse bookTicket(BookingRequest bookingRequest);
}
