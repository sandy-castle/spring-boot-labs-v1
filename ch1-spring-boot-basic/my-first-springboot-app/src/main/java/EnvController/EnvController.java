package EnvController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @Autowired
            //의존성 주입
    Environment env;
    @GetMapping
    public String getEnv() {
      return   env.getProperty("server.port");
    }

}
