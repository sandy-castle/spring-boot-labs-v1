package di_with_bean.cafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Barista {

    private final CafeMachine machine;

    @Autowired
    public Barista(CafeMachine machine) {
        this.machine = machine;
    }

    public String makeCoffee() {
        return machine.brew();
    }
}
