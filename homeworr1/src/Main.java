public class Main {
    public static void main(String[] args) {
        // 고객 객체 생성
        Customer UserWeb = new UserWeb("웹 유저", Customer.Grade.GOLD);
        Customer userMobile = new UserMobile("모바일 유저", Customer.Grade.BRONZE);

        // 계산 메서드 사용
        double price1 =10000;
        double price2 = 10000;

        // 유저 정보 출력
        System.out.println("======================");
        UserWeb.userInfo();
        System.out.println("결제 금액: " + UserWeb.calculatePrice(price1));
        System.out.println("======================");
        userMobile.userInfo();
        //System.out.println("보너스: "+userMobile.);
        System.out.println("보너스 : "+ userMobile.calculateBonus(price2));
        System.out.println("결제 금액: " + price2);
        System.out.println("======================");
    }
}
