package component_scan;

import org.springframework.stereotype.Component;

@Component
public class HelloComponentBean {
    public String sayHello() {
        return "Hello from component!";
    }
}
