package dio.springBoot_beans_autowired.app;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;

public class Beans {
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
