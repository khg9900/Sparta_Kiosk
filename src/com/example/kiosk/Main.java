package com.example.kiosk;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItem = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItem.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


        // Scanner 객체 선언
        Scanner sc = new Scanner(System.in);

        // 키오스크 첫 화면
        System.out.println("[ SHAKESHACK MENU ]");

        for (int i = 0; i < menuItem.size(); i++) {
            System.out.print(i+1 + ". ");
            menuItem.get(i).showMenu();
        }

        System.out.println("0. 종료          | 종료");

        // 메뉴 선택
        int choice = sc.nextInt();
        System.out.println();

        try {
            if (choice != 0) {
                menuItem.get(choice - 1).showMenu();
            } else {
                System.out.println("프로그램을 종료합니다.");
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("다시 입력해주세요.");
        }


    }
}
