package spring.autowire.sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        FooService fooService = ctx.getBean(FooService.class);
        final String result = fooService.doStuff();
        System.out.println(result);
    }
}
