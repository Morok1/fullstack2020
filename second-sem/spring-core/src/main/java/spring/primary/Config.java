package spring.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="spring.primary")
public class Config {

    @Bean
    public Employee johnEmployee(){
        return new Employee("John");
    }

    @Bean
    @Primary
    public Employee tonyEmployee(){
        return new Employee("Tony");
    }
}
