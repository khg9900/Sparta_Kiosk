package com.example.kiosk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 1. 속성
    private List<MenuItem> cartItems = new ArrayList<>();
    private BigDecimal totalPrice = new BigDecimal(0);

    // 2. 생성자

    // 3. 기능
    // 장바구니 확인하기
    public void showCartItems() {
        System.out.println("\n[ Orders ]");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.print(i+1 + ". ");
            cartItems.get(i).showMenuItem();
        }
        System.out.println("\n[ Total ]");
        System.out.println("W "+ this.totalPrice);
    }

    // 장바구니에 메뉴 담기
    public void addCartItem(MenuItem menuItem) {
        this.cartItems.add(menuItem);
        this.totalPrice = this.totalPrice.add(BigDecimal.valueOf(menuItem.getMenuPrice()));
        System.out.println(menuItem.getMenuName() + "이 장바구니에 추가되었습니다.");
    }

    // 장바구니에서 메뉴 삭제하기
    public void removeCartItem(int number) {
        this.totalPrice = this.totalPrice.subtract(BigDecimal.valueOf(cartItems.get(number).getMenuPrice()));
        this.cartItems.remove(number);
        System.out.println("주문이 수정되었습니다.");
        showCartItems();
    }

    // 장바구니에 담은 메뉴 주문
    public void orderCartItems() {
        System.out.println("\n주문이 완료되었습니다. 금액은 W " + this.totalPrice + " 입니다.\n");
        this.cartItems.clear();
        this.totalPrice = BigDecimal.valueOf(0);
    }

    public List<MenuItem> getCart() {
        return this.cartItems;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
