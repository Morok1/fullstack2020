package spring.bean.config;

import spring.bean.injection.Helm;
import spring.bean.injection.Ship;
import org.springframework.context.annotation.Bean;

public class SetterBasedShipConfig {

    @Bean
    public Ship ship() {
        return new Ship();
    }

    @Bean
    public Helm helm() {
        return new Helm();
    }
}
