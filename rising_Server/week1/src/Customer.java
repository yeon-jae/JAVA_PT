// 최상위 고객 객체를 추상 클래스로 만듦
public abstract class Customer {
    // 공통 멤버 변수 (이름, 등급, 할인방식)
    public String name;
    public Grade grade;
    public Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    // 등급 enum
    public enum Grade {
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
            this.discount = new BonusDiscount(grade.getDiscountRate());
        } else {
            this.discount = new DirectDiscount(grade.getDiscountRate());
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
    public abstract void displayUserInfo();

    // 계산 메서드
    public double calculatePrice(double price) {
        return discount.applyDiscount(price);
    }
    // 보너스 포인트 반환 메서드
    public double getBonusPoint() {
        // 보너스 방식은 BonusDiscount 클래스의 getBonusPoint() 메서드를 활용
        if (discount instanceof BonusDiscount) {
            return ((BonusDiscount) discount).getBonusPoint();
        } else {
            return 0.0;
        }
    }
}
