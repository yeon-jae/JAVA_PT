// 할인 방식 할인 구현
public class MinusDiscount implements Discount {//할인방식
    private double discountRate;

    public MinusDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * discountRate);
    }

    @Override
    public double applyBonus(double price) {
        return 0.0; // 할인 방식은 보너스 포인트를 적용하지 않으므로 0.0을 반환
    }
}