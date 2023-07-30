import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 고객 리스트 생성
        List<Customer> customerList = new ArrayList<>();

        // 웹 유저와 모바일 유저 객체 생성 및 고객 리스트에 추가
        Customer userWeb = new UserWeb("웹 유저", Customer.Grade.BRONZE);
        Customer userMobile = new UserMobile("모바일 유저", Customer.Grade.GOLD);
        customerList.add(userWeb);
        customerList.add(userMobile);

        // 고객 정보 출력 및 가격 계산
        for (Customer customer : customerList) {
            System.out.println("======================");
            customer.displayUserInfo();
            double price = 10000;
            double discountedPrice = customer.calculatePrice(price);
            System.out.println("가격: " + discountedPrice);
            System.out.println("보너스 포인트: " + customer.getBonusPoint());
        }
    }
}
