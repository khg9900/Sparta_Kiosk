package com.example.kiosk;

import java.util.Scanner;
import java.util.InputMismatchException;

public class getInput {

    // 1. 속성

    // 2. 생성자

    // 3. 기능
    public static int getIntInput(Scanner sc) {
        while(true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) { // 정수만 입력 가능.
                System.out.println("잘못된 입력입니다.");
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
