
// 모바일 유저 클래스
class UserMobile extends Customer {
    public UserMobile(String name, Grade grade) {
        super(name, grade);
    }

    @Override
    public void displayUserInfo() {
        System.out.println("접속 경로: 모바일");
        System.out.println("이름: " + getName());
        System.out.println("등급: " + getGrade());
        System.out.println("할인 방식: " + discount.getClass().getSimpleName());
    }
}