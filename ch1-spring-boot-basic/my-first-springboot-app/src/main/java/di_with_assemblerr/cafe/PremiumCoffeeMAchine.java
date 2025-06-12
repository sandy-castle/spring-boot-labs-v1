package di_with_assemblerr.cafe;

import org.springframework.stereotype.Component;

@Component
public class PremiumCoffeeMAchine implements CafeMachine {
    @Override
    public String brew() {
        return "프리미엄 커피가 나왔습니다.";
    }
}
