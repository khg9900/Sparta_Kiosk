package com.example.kiosk;

public class MenuItem {

    // 1. 속성
    private String menuName;
    private double menuPrice;
    private String menuDesc;

    // 2. 생성자
    public MenuItem(String menuName, double menuPrice, String menuDesc){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDesc = menuDesc;
    }

    // 3. 기능
    public void showMenu() {
        System.out.printf("%-13s| W %.1f | %s%n",menuName, menuPrice, menuDesc);
    }

}
