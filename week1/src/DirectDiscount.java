// 할인 방식 구현
public class DirectDiscount implements Discount {
    private double discountRate;

    public DirectDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        // 할인 방식은 지불 금액에서 곧바로 할인 비율만큼 금액을 차감
        return price - (price * discountRate);
    }

    @Override
    public double getBonusPoint() {
        return 0;
    }
}