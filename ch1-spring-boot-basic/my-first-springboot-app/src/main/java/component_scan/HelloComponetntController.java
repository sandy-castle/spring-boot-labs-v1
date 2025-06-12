package component_scan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloComponentController {

    private HelloComponentBean component;

    @Autowired
    public void setComponent(HelloComponentBean component) {
        this.component = component;
    }

    @GetMapping("/hello-component")
    public String helloComponent() {
        return component.sayHello();
    }
}
