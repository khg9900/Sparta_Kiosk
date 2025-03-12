package com.example.kiosk;

import java.math.BigDecimal;

public enum Discount {

    MILITARY("군인", "5%") {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice.multiply(BigDecimal.valueOf(0.95));
        }
    },
    STUDENT("학생", "3%") {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice.multiply(BigDecimal.valueOf(0.97));
        }
    },
    GENERAL("일반", "0%") {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice;
        }
    };

    private String type;
    private String percent;

    Discount(String type, String percent) {
        this.type = type;
        this.percent = percent;
    }

    public String getType() {
        return this.type;
    }

    public String getPercent() {
        return this.percent;
    }

    public abstract BigDecimal discountPrice(BigDecimal totalPrice);

}
