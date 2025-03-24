package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void findBenaByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> applicationContext.getBean(DiscountPolicy.class));
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy FixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
