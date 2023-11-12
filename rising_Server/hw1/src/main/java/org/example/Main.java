package org.example;

import static sun.security.pkcs.PKCS9Attribute.getName;

// 등급을 나타내는 enum
enum Grade {
    BRONZE(0.1),
    SILVER(0.2),
    GOLD(0.3);

    private final double discountRate;

    Grade(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

// 할인 방식을 나타내는 인터페이스
interface DiscountStrategy {
    double applyDiscount(double amount, Grade grade);
}

// 보너스 방식
class BonusDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount, Grade grade) {
        return amount - (amount * grade.getDiscountRate());
    }
}

// 할인 방식
class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount, Grade grade) {
        return amount + (amount * grade.getDiscountRate());
    }
}

// 웹에서 접속하는 유저
class WebCustomer extends Customer {
    public WebCustomer(String name, Grade grade) {
        super(name, grade);
    }

    @Override
    public void printUserInfo() {
        System.out.println("접속 경로: 웹");
        System.out.println("고객 이름: " + getName());
        System.out.println("등급: " + getGrade());
    }
}

// 모바일에서 접속하는 유저
class MobileCustomer extends Customer {
    public MobileCustomer(String name, Grade grade) {
        super(name, grade);
    }

    @Override
    public void printUserInfo() {
        System.out.println("접속 경로: 모바일");
        System.out.println("고객 이름: " + getName());
        System.out.println("등급: " + getGrade());
    }
}

// 테스트 예시
public class Main {
    public static void main(String[] args) {
        // 유저 생성
        Customer customer1 = new WebCustomer("Alice", Grade.SILVER);
        Customer customer2 = new MobileCustomer("Bob", Grade.GOLD);

        // 유저 정보 출력
        customer1.printUserInfo();
        System.out.println("가격 계산 결과: " + customer1.calculatePrice(100));

        customer2.printUserInfo();
        System.out.println("가격 계산 결과: " + customer2.calculatePrice(200));

        // 특정 유저의 등급 변경 후 가격 계산
        customer2.setGrade(Grade.BRONZE);
        System.out.println("변경된 등급: " + customer2.getGrade());
        System.out.println("가격 계산 결과: " + customer2.calculatePrice(200));
    }
}
