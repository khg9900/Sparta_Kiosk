package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 1. 속성
    public List<MenuItem> menuItems = new ArrayList<>(); // MenuItem을 관리하는 리스트

    // 2. 생성자
    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    // 3. 기능
    public void start(){

        // Scanner 객체 선언
        Scanner sc = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i+1 + ". ");
            menuItems.get(i).showMenu();
        }
        System.out.println("0. 종료          | 종료");

        while(true) {
            // 메뉴 선택
            int choice = sc.nextInt();

            try {
                if (choice != 0) {
                    menuItems.get(choice - 1).showMenu();
                } else {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println("다시 입력해주세요.");
            }
        }
    }


}
