package di_with_assemblerr;

import di_with_assemblerr.cafe.Barista;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    private final Barista barista;

    public CoffeeController(Barista barista) {
        this.barista = barista;
    }

    @GetMapping("/coffee")
    public String serveCoffee() {
        return barista.makeCoffee();
    }
}
