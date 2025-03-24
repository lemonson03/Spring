package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("1")
    void findAllBean(){

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println(bean + beanDefinitionName);
        }
    }
    @Test
    @DisplayName("2")
    void findApplicationAllBean(){

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = applicationContext.getBean(beanDefinitionName);

                System.out.println(beanDefinitionName + bean);
            }
        }
    }

}
