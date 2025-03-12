package com.example.kiosk;

public class MenuItem {

    // 1. 속성
    private String menuName; // 메뉴 이름
    private double menuPrice; // 메뉴 가격
    private String menuDesc; // 메뉴 설명

    // 2. 생성자
    public MenuItem(String menuName, double menuPrice, String menuDesc){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDesc = menuDesc;
    }

    // 3. 기능
    public void showMenuItem() {
        System.out.printf("%-13s| W %.1f | %s%n",menuName, menuPrice, menuDesc);
    }

    public String getMenuName(){
        return this.menuName;
    }

    public double getMenuPrice() {
        return this.menuPrice;
    }

}
