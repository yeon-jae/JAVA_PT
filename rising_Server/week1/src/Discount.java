// 할인 방식을 나타내는 인터페이스
interface Discount {
    double applyDiscount(double price);
    double getBonusPoint();
}