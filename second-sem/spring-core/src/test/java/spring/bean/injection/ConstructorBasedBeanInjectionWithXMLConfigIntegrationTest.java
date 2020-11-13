package spring.bean.injection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.injection.Ship;

public class ConstructorBasedBeanInjectionWithXMLConfigIntegrationTest {

    private static final String HELM_NAME = "HelmBrand";

    @Test
    public void givenXMLConfigFile_whenUsingConstructorBasedBeanInjection_thenCorrectHelmName() {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanInjection-constructor.xml");

        final Ship shipConstructorBean = (Ship) applicationContext.getBean("ship");
        Assert.assertEquals(HELM_NAME, shipConstructorBean.getHelm().getBrandOfHelm());
    }
}
