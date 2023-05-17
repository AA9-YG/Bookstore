package com.membercard;

public interface DiscountEligible {
    static boolean discount(double price) {
        if (price >= 50) return true;

        return false;
    }
}
