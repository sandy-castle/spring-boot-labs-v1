package di_with_bean;

import di_with_bean.cafe.Barista;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeController2 {

    private final Barista barista;

    public CafeController2(Barista barista) {
        this.barista = barista;
    }

    @GetMapping("/coffee")
    public String serveCoffee() {
        return barista.makeCoffee();
    }
}
