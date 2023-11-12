// 보너스 방식 할인 구현
class BonusPlus implements Discount {
    private double discountRate;


    public BonusPlus(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * discountRate);
    }

    @Override
    public double applyBonus(double price) {
        return (price*discountRate);
    }

}
