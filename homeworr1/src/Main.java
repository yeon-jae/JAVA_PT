// 할인 방식을 나타내는 인터페이스
interface DiscountStrategy {
    double applyDiscount(double price);
}

// 보너스 방식 할인 구현
class BonusDiscount implements DiscountStrategy {
    private double discountRate;

    public BonusDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * discountRate);
    }
}

// 할인 방식 할인 구현
class DirectDiscount implements DiscountStrategy {
    private double discountRate;

    public DirectDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * discountRate);
    }
}


// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 고객 객체 생성
        Customer UserWeb = new UserWeb("웹 유저", Customer.Grade.BRONZE);
        Customer userMobile = new UserMobile("모바일 유저", Customer.Grade.GOLD);

        // 계산 메서드 사용
        double price1 =7000;
        double price2 = 10000;

        // 유저 정보 출력
        System.out.println("======================");
        UserWeb.userInfo();
        System.out.println("가격 (웹 유저): " + UserWeb.calculatePrice(price1));
        System.out.println("======================");
        userMobile.userInfo();
        System.out.println("가격 (모바일 유저): " + userMobile.calculatePrice(price2));
        System.out.println("======================");
    }
}
