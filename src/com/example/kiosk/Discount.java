package com.example.kiosk;

import java.math.BigDecimal;

public enum Discount {

    MILITARY(1, "군인", 5) {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice.multiply(BigDecimal.valueOf(0.95));
        }
    },
    STUDENT(2, "학생", 3) {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice.multiply(BigDecimal.valueOf(0.97));
        }
    },
    GENERAL(3, "일반", 0) {
        @Override
        public BigDecimal discountPrice(BigDecimal totalPrice) {
            return totalPrice;
        }
    };

    private int seq;
    private String type;
    private int percent;

    Discount(int seq, String type, int percent) {
        this.seq = seq;
        this.type = type;
        this.percent = percent;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getType() {
        return this.type;
    }

    public int getPercent() {
        return this.percent;
    }

    public static Discount fromInt(int discountChoice) {
        for (Discount d : Discount.values()){
            if (d.seq == discountChoice){
                return d;
            }
        }
        return null;
    }

    public abstract BigDecimal discountPrice(BigDecimal totalPrice);

}
