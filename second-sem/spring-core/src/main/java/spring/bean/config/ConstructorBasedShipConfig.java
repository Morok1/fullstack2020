package spring.bean.config;

import spring.bean.injection.Helm;
import spring.bean.injection.Ship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstructorBasedShipConfig {


    @Bean
    public Ship ship() {
        return new Ship(helm());
    }

    @Bean
    public Helm helm() {
        return new Helm();
    }
}
