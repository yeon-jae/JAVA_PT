// 보너스 방식 할인 구현
public class BonusDiscount implements Discount {
    private double discountRate;
    private double bonusPoint;

    public BonusDiscount(double discountRate) {
        this.discountRate = discountRate;
        this.bonusPoint = 0.0;
    }

    @Override
    public double applyDiscount(double price) {
        // 보너스 방식은 할인 비율만큼 보너스 포인트에 더하고, 지불 금액을 반환
        bonusPoint += price * discountRate;
        return price - (price * discountRate);
    }

    // 보너스 포인트 Getter 메서드
    public double getBonusPoint() {
        return bonusPoint;
    }
}
