// Customer 클래스 - 최상위 추상 클래스
public abstract class Customer {
    // 공통 멤버 변수 (이름, 등급, 할인방식)
    public String name;
    public Grade grade;
    public Discount discount;

    //등급 enum
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

            this.discount = new BonusPlus(grade.getDiscountRate());
        } else {
            this.discount = new MinusDiscount(grade.getDiscountRate());
        }
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
        // 등급에 따라 할인 방식 설정
        if (grade == Grade.GOLD) {
            this.discount = new BonusPlus(grade.getDiscountRate());
        } else {
            this.discount = new MinusDiscount(grade.getDiscountRate());
        }
    }

    // 고객 정보 출력 메서드 (추상 메서드)
    public abstract void userInfo();


        // 계산 메서드
        public double calculatePrice(double price) {
            double discountedPrice = discount.applyDiscount(price);
            return Math.round(discountedPrice * 100) / 100.0; // 소수점 둘째 자리까지 반올림
        }


      //보너스 반환
    public double calculateBonus(double price){
            double discountBonus= discount.applyBonus(price);
            return Math.round(discountBonus * 100) / 100.0; // 소수점 둘째 자리까지 반올림

    }
    }
