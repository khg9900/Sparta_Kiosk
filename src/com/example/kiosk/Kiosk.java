package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 1. 속성
    private List<Menu> category = new ArrayList<>();

    // 2. 생성자
    public Kiosk(List<Menu> category) {
        this.category = category;
    }

    // 3. 기능
    public void start() {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        // 장바구니
        Cart cart = new Cart();

        // 반복문 시작
        while (true) {

            // 카테고리 출력
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < category.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(category.get(i).getCategoryName());
            }
            System.out.println("0. 종료          | 종료");

            // 장바구니에 메뉴가 담겨있을 때만 출력
            if (!cart.getCartItems().isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(category.size() +1 + ". Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println(category.size() +2 + ". Cancel       | 진행중인 주문을 취소합니다.");
            }

            // 카테고리 선택
            int categoryChoice = sc.nextInt();

            try {
                // 해당 카테고리의 메뉴 출력
                Menu menu = category.get(categoryChoice - 1);
                menu.showMenuItems();

                // 메뉴 선택
                int menuChoice = sc.nextInt();
                // 0. 뒤로가기
                if (menuChoice == 0) {
                    continue;
                }

                MenuItem menuItem = menu.getMenuItems().get(menuChoice - 1);

                // 선택한 메뉴 출력
                System.out.print("선택한 메뉴: ");
                menuItem.showMenuItem();

                // 장바구니 기능
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 취소");

                int addToCart = sc.nextInt();
                if (addToCart == 1) {
                    // 장바구니 추가
                    cart.addCartItem(menuItem);
                } else {
                    // 취소
                    System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                }

            } catch (IndexOutOfBoundsException e){
                if (categoryChoice == 0) {
                    // 0. 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (!cart.getCartItems().isEmpty()) {
                    // 장바구니에 메뉴가 담겨있을 때만 선택 가능
                    if (categoryChoice == category.size()+1) {
                        // 장바구니 목록 및 총 금액 출력
                        System.out.println("\n아래와 같이 주문하시겠습니까?");
                        cart.showCart();
                        // 주문 여부 선택
                        System.out.println("\n1. 주문       2. 메뉴판");
                        int orderChoice = sc.nextInt();
                        if (orderChoice == 1) {
                            // 주문
                            cart.orderCart();
                        }
                    } else if (categoryChoice == category.size() + 2) {
                        // 장바구니 목록 수정
                        System.out.println("주문 취소할 메뉴를 선택해주세요.");
                        cart.showCart();
                        int removeChoice = sc.nextInt();
                        // 메뉴 삭제
                        try {
                            cart.removeItem(removeChoice);
                        } catch (IndexOutOfBoundsException exception) {
                            System.out.println("취소할 메뉴가 없습니다.");
                        }
                    }
                } else {
                    System.out.println("선택된 메뉴가 없습니다.");
                }

            }

        }

    }

}

