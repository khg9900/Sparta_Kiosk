package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.getInput.getIntInput;


public class Kiosk {

    // 1. 속성
    private List<Menu> menu = new ArrayList<>();

    // 2. 생성자
    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    // 3. 기능
    public void start() {

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        // 장바구니
        Cart cart = new Cart();

        // 반복문 시작
        while (true) {

            // 메뉴 카테고리 출력
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(menu.get(i).getCategoryName());
            }
            System.out.println("0. 종료          | 종료");

            // 장바구니에 메뉴가 담겨있을 때만 출력
            if (!cart.getCart().isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(menu.size() + 1 + ". Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println(menu.size() + 2 + ". Cancel       | 진행중인 주문을 취소합니다.");
            }

            // 카테고리 선택
            int categoryChoice = getIntInput(sc);

            if (categoryChoice == 0) { // 0. 종료
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (categoryChoice > 0 && categoryChoice <= menu.size()) { // 1 ~ 3. 메뉴 선택
                // 선택한 카테고리의 메뉴 출력
                Menu category = menu.get(categoryChoice - 1);
                category.showMenuItems();

                // 메뉴 선택
                int menuChoice = getIntInput(sc);

                // 0 or 메뉴와 다른 숫자 선택 시 뒤로가기
                if (menuChoice <= 0 || menuChoice > category.getMenuItems().size()) {
                    continue;
                }

                // 선택한 메뉴 출력
                MenuItem menuItem = category.getMenuItems().get(menuChoice - 1);
                System.out.print("선택한 메뉴: ");
                menuItem.showMenuItem();

                // 장바구니 기능
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 취소");

                // 장바구니에 담을 지 선택
                int addToCart = getIntInput(sc);
                if (addToCart == 1) {
                    // 장바구니 추가
                    cart.addCartItem(menuItem);
                } else {
                    // 1외의 다른 숫자 입력할 경우 첫 화면으로 돌아감
                    System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                }

            } else if (!cart.getCart().isEmpty()) { // 장바구니에 메뉴가 있을 때에만 선택 가능
                if (categoryChoice == menu.size() + 1) { // 4. 장바구니 조회
                    // 장바구니 목록 및 총 금액 출력
                    System.out.println("\n아래와 같이 주문하시겠습니까?");
                    cart.showCartItems();

                    // 주문 여부 선택
                    System.out.println("\n1. 주문       2. 메뉴판");
                    int orderChoice = getIntInput(sc);

                    // 주문 선택시 할인 정보 출력
                    if (orderChoice == 1) {
                        // 할인 정보
                        System.out.println("\n할인 정보를 입력해주세요.");
                        for (Discount d : Discount.values()) {
                            System.out.println((d.ordinal() + 1) + ". " + d.getType() + " : " + d.getPercent() + "%");
                        }

                        // 할인 선택
                        int discountChoice = getIntInput(sc);
                        // enum으로 변환
                        Discount discount = Discount.fromInt(discountChoice);

                        if (discount == null) { // 다른 숫자 입력했을 경우 넘기기
                            System.out.println("잘못된 입력입니다.");
                            continue;
                        }

                        // 할인율 적용
                        cart.setTotalPrice(discount.discountPrice(cart.getTotalPrice()));

                        // 주문
                        cart.orderCartItems();
                        // 주문이 완료되면 프로그램 종료
                        break;
                    }
                    // 메뉴판 or 다른 숫자 입력시 자동으로 첫 화면으로 이동

                } else if (categoryChoice == menu.size() + 2) { // 5. 장바구니 삭제
                    // 장바구니 목록 수정
                    System.out.print("\n현재 장바구니 목록");
                    cart.showCartItems();

//                    // 삭제할 메뉴 선택
//                    int removeChoice = getIntInput(sc);
//
//                    // 메뉴 삭제
//                    try {
//                        cart.removeCartItem(removeChoice - 1);
//                    } catch (IndexOutOfBoundsException exception) {
//                        System.out.println("취소할 메뉴가 없습니다.");
//                    }

                    sc.nextLine(); // 버퍼 비우기
                    // 문자열 입력받아 스트림으로 메뉴 삭제
                    System.out.print("\n주문 취소할 메뉴를 선택해주세요: ");
                    String removeMenu = sc.nextLine();
                    System.out.println(removeMenu);
                    cart.removeCartItem(removeMenu);


                } else {
                    System.out.println("선택된 메뉴가 없습니다.");
                }
            } else { // 메인 메뉴에서 잘못된 입력 처리
                System.out.println("선택된 메뉴가 없습니다.");
            }

        }

    }

}

