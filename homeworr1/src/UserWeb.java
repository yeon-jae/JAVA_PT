// 웹 유저 클래스
public class UserWeb extends Customer {
    public UserWeb(String name, Grade grade) {
        super(name, grade);
    }

    @Override
    public void userInfo() {
        System.out.println("접속 경로: Web");
        System.out.println("이름: " + getName());
        System.out.println("등급: " + getGrade());
        System.out.println("결제 방식: " + (getGrade() == Grade.GOLD ? "보너스 방식" : "할인 방식"));
    }
}
