package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void testBeanLifeCycle() {
       ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient nc = ac.getBean(NetworkClient.class);

    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkclient() {
            return new NetworkClient("https://www.naver.com");
        }
    }

}
