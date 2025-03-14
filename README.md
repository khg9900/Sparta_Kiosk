# 내일배움캠프 CH2 키오스크 과제

## 과제 소개
* 목표 : 간단한 키오스크 프로그램을 구현하며 자바의 기본 문법과 객체 지향 프로그래밍의 개념 익히기
* 기간 : 25.03.07 ~ 03.14
* 언어: Java
* 개발 환경: IntelliJ IDEA

## 클래스
* Main.java : 메뉴 데이터 입력, Kiosk.start()
* Kiosk.java : 프로그램 순서 및 흐름 제어
* Menu.java : MenuItem 클래스를 List로 관리. 카테고리 정보 저장
* MenuItem.java : 세부 메뉴 속성(메뉴 이름, 가격, 설명) 가지는 클래스
* Cart.java : 장바구니 기능
* getInput.java : 문자 입력 오류 제어
* Discount.java : 할인 정보 저장 enum

## 주요 기능
1. 메뉴 출력 / 선택
2. 장바구니 추가 / 조회 / 삭제
3. 할인 적용 / 주문

## 실행 화면
1. 프로그램 실행 시 메뉴 카테고리가 출력됩니다.
<img width="445" src="https://github.com/user-attachments/assets/d4d99be1-8fa9-4895-b22a-63fc5c51a1bc" />

2. 원하는 카테고리를 선택하면 해당 카테고리의 메뉴와 세부 정보가 출력됩니다.
<img width="530" src="https://github.com/user-attachments/assets/7522be3a-4489-43c3-95cb-14f7628e2a7c" />

3. 원하는 메뉴를 선택하면 해당 메뉴를 장바구니에 추가할 수 있습니다.
<img width="529" src="https://github.com/user-attachments/assets/3a183a3f-6d90-43b7-a96c-586cf038a2a8" />


4. 장바구니에 메뉴가 추가되면 첫 화면(메뉴 카테고리 출력 부분) 아래에 장바구니 기능 관련 선택지가 표시됩니다.
<img width="529" src="https://github.com/user-attachments/assets/681bcfdf-a530-4708-bf03-c0e93e1fca93" />

5. 장바구니 확인 및 주문 기능을 선택하면 장바구니에 담긴 메뉴 목록과 총 가격을 조회할 수 있고, 이후 할인 타입을 선택하면 주문이 완료됩니다.
<img width="529" src="https://github.com/user-attachments/assets/f5cd441d-137c-4913-8c51-8606ac6d3253" />

6. 주문 취소 기능을 선택하면 현재 장바구니에 담긴 목록과 총 가격을 보여주고, 이후 취소할 메뉴를 입력할 수 있습니다. <br>
메뉴명을 올바르게 입력하면 주문 수정이 완료되었다는 메시지와 함께 수정된 내역을 볼 수 있습니다.
<img width="529" alt="스크린샷 2025-03-14 오후 12 39 42" src="https://github.com/user-attachments/assets/c02b5295-5396-48b2-bf72-7c87b4503214" />

<hr>

* 선택지 외 다른 숫자를 입력할 경우 자동으로 첫 화면(메뉴 카테고리)으로 돌어갑니다.
* 문자를 입력할 경우 "잘못된 입력입니다." 메시지가 출력되고, 이후 재입력이 가능합니다.



