package spring.bean.injection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.bean.config.ConstructorBasedShipConfig;
import spring.bean.injection.Ship;

public class ConstructorBasedBeanInjectionWithJavaConfigIntegrationTest {
    private static final String HELM_NAME = "HelmBrand";

    @Test
    public void givenJavaConfigFile_whenUsingConstructorBasedBeanInjection_thenCorrectHelmName() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConstructorBasedShipConfig.class);
        ctx.refresh();

        Ship ship = ctx.getBean(Ship.class);

        Assert.assertEquals(HELM_NAME, ship.getHelm().getBrandOfHelm());
    }
}
