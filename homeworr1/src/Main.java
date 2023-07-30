import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 고객 객체 생성
        Customer UserWeb = new UserWeb("웹 유저", Customer.Grade.GOLD);
        Customer userMobile = new UserMobile("모바일 유저", Customer.Grade.BRONZE);

        // 고객 리스트 생성 및 추가
        List<Customer> customerList = new ArrayList<>();
        customerList.add(UserWeb);
        customerList.add(userMobile);

        // 계산 메서드 사용
        double price1 = 10000;
        double price2 = 10000;

        // 고객 정보 출력
        for (Customer customer : customerList) {
            System.out.println("======================");
            customer.userInfo();
            System.out.println("결제 금액: " + customer.calculatePrice(price1));
            if (customer instanceof BonusPlus) {
                BonusPlus bonusDiscount = (BonusPlus) customer;
                System.out.println("보너스 : " + bonusDiscount.calculateBonus(price2));
            }
            System.out.println("결제 금액: " + customer.calculatePrice(price2));
            System.out.println("======================");
        }
    }
}
