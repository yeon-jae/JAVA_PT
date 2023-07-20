// Customer 클래스 - 최상위 추상 클래스
public abstract class Customer {
    // 공통 멤버 변수 (이름, 등급, 할인방식)
    private String name;
    private Grade grade;
    private DiscountStrategy discountStrategy;

    // 등급 enum
    enum Grade {
        BRONZE(0.1),
        SILVER(0.2),
        GOLD(0.3);

        private double discountRate;

        Grade(double discountRate) {
            this.discountRate = discountRate;
        }

        public double getDiscountRate() {
            return discountRate;
        }
    }

    // 생성자
    public Customer(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
        // 등급에 따라 할인 방식 설정
        if (grade == Grade.GOLD) {
            this.discountStrategy = new BonusDiscount(grade.getDiscountRate());
        } else {
            this.discountStrategy = new DirectDiscount(grade.getDiscountRate());
        }
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    // 고객 정보 출력 메서드 (추상 메서드)
    public abstract void userInfo();

    // 계산 메서드
    public double calculatePrice(double price) {
        double discountedPrice = discountStrategy.applyDiscount(price);
        return Math.round(discountedPrice * 100) / 100.0; // 소수점 둘째 자리까지 반올림
    }
}
