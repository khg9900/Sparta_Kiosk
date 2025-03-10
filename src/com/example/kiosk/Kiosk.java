package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 1. 속성
    private List<Menu> category = new ArrayList<>();

    // 2. 생성자
    public Kiosk(List<Menu> category){
        this.category = category;
    }

    // 3. 기능
    public void start(){

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while(true) {

            // 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < category.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(category.get(i).getCategoryName());
            }
            System.out.println("0. 종료          | 종료");

            // 카테고리 선택
            int categoryChoice = sc.nextInt();
            try {
                if (categoryChoice != 0) {
                    // 선택된 카테고리의 메뉴 출력
                    Menu menu = category.get(categoryChoice - 1);
                    menu.showMenuItem();

                    while (true) {
                        // 메뉴 선택
                        int menuChoice = sc.nextInt();
                        try {
                            if (menuChoice != 0) {
                                // 선택한 메뉴 출력
                                System.out.print("선택한 메뉴: ");
                                menu.getMenuItems().get(menuChoice - 1).showMenuItem();
                            } else {
                                // 0. 뒤로 가기
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            // 메뉴 번호 잘못 입력
                            System.out.println("다시 입력해주세요.");
                        } catch (Exception e) {
                            // 다른 문자 입력
                            System.out.println("잘못된 입력입니다.");
                        }
                    }

                } else {
                    // 0. 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            } catch (IndexOutOfBoundsException e) {
                // 카테고리 번호 잘못 입력
                System.out.println("다시 입력해주세요.");
            } catch (Exception e) {
                // 다른 문자 입력
                System.out.println("잘못된 입력입니다.");
            }

        }

    }

    public List<Menu> getCategory() {
        return this.category;
    }
}
