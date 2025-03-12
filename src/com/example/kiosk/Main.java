package com.example.kiosk;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu burgerMenu = new Menu("Burgers");
        Menu drinkMenu = new Menu("Drinks");
        Menu sidetMenu = new Menu("Sides");

        // Menu 클래스 내 있는 List<MenuItem>에 MenuItem 객체 생성하면서 삽입
        burgerMenu.getMenuItems().add(new MenuItem("ShackBurger", 8.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("SmokeShack", 11.1, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("ShackStack", 15.3, "버섯과 비프 패티에 야채와 쉑소스가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("Hamburger", 7.3, "비프 패티를 기반으로 야채가 들어간 기본버거"));

        drinkMenu.getMenuItems().add(new MenuItem("FountainSoda", 2.9, "코카콜라, 스프라이트, 환타"));
        drinkMenu.getMenuItems().add(new MenuItem("Lemonade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinkMenu.getMenuItems().add(new MenuItem("ShackCoffee", 4.0, "쉑 블렌드 원두를 사용한 밸런스 좋은 블랙 커피"));

        sidetMenu.getMenuItems().add(new MenuItem("Fries", 4.9, "바삭하고 담백한 크링클 컷 프라이"));
        sidetMenu.getMenuItems().add(new MenuItem("CheeseFries", 6.0, "치즈 소스를 듬뿍 올린 크링클 컷 프라이"));

        // Menu 카테고리 목록으로 저장
        List<Menu> category = new ArrayList<>();
        category.add(burgerMenu);
        category.add(drinkMenu);
        category.add(sidetMenu);

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(category);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();

    }
}
