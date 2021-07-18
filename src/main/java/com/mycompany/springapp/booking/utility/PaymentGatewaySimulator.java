package com.mycompany.springapp.booking.utility;

import com.mycompany.springapp.booking.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimulator {
    private PaymentGatewaySimulator(){}

    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    static{
        accountBalanceMap.put("acnt-1212", 2000.00);
        accountBalanceMap.put("acnt-1313", 4000.00);
        accountBalanceMap.put("acnt-1414", 3000.00);
    }

    public static boolean validateFareBalanceCriteria(String accuntNo, Double fare) {
        if(fare > accountBalanceMap.get(accuntNo)){
            throw new InsufficientBalanceException("You do not have sufficient balance");
        }
        return true;
    }


}
