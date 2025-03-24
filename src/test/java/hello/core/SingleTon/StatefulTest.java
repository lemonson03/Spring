package hello.core.SingleTon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulTest {
    @Test
    @DisplayName("싱글톤 패턴의 주의점")
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = context.getBean(StatefulService.class);
        StatefulService statefulService2 = context.getBean(StatefulService.class);
    //Thread A와 B
    statefulService2.Order("usera",100);
    statefulService1.Order("userb",120);

    }
    static class TestConfig{
        @Bean
        public StatefulService staefulservice(){
            return new StatefulService();
        }
    }
}
