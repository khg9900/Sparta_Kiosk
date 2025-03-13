package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    // 1. 속성
    // 카테고리 이름
    private String categoryName;
    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menuItems = new ArrayList<>();

    // 2. 생성자
    public Menu(String categoryName){
        this.categoryName = categoryName;
    }

    // 3. 기능
    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItems(){
        System.out.println("\n[ "+ this.categoryName.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i+1 + ". ");
            menuItems.get(i).showMenuItem();
        }
        System.out.println("0. 뒤로가기");
    }

    // 카테고리 이름 리턴
    public String getCategoryName() {
        return this.

                categoryName;
    }

    // List 리턴
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

}
