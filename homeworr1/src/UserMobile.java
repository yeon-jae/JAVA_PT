public class UserMobile extends Customer {    // 모바일 유저 클래스
    public UserMobile(String name, Grade grade) {
        super(name, grade);
    }

    @Override
        public void userInfo() {
            System.out.println("접속 경로: Mobile");
            System.out.println("이름: " + getName());
            System.out.println("등급: " + getGrade());
            System.out.println("결제 방식: " + (getGrade() == Grade.GOLD ? "할인 결제 방식" : "보너스 방식"));
        }

    }


