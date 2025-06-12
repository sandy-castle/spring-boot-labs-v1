package di_with_assemblerr.cafe;

import org.springframework.stereotype.Component;

@Component
public class BasicCoffeeMachine implements CafeMachine {
    @Override
    public String brew() {
        return "기본 커피가 나왔습니다.";
    }
}
