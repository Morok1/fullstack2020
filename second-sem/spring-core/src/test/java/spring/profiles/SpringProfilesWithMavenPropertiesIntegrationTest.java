package spring.profiles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import spring.profiles.DatasourceConfig;
import spring.profiles.DevDatasourceConfig;
import spring.profiles.SpringProfilesConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringProfilesConfig.class }, loader = AnnotationConfigContextLoader.class)
public class SpringProfilesWithMavenPropertiesIntegrationTest {

    @Autowired
    DatasourceConfig datasourceConfig;

    @Test
    public void setupDatasource() {
        Assert.assertTrue(datasourceConfig instanceof DevDatasourceConfig);
    }
}