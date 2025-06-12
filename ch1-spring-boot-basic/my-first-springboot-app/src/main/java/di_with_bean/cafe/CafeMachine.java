package di_with_bean.cafe;

public class CafeMachine {

    public void powerOn() {
        System.out.println("커피 머신의 전원을 켭니다.");
    }

    public void heatWater() {
        System.out.println("물을 데웁니다.");
    }

    public void brew() {
        System.out.println("커피를 내립니다.");
    }

    public void powerOff() {
        System.out.println("사용을 마치고 전원을 끕니다.");
    }
}
