package hello.core.BeanDefinition;
import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Role;

public class BeanDefinitionTest {

AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

@Test
    @DisplayName("빈 정보 확인")
    void findApplicationBean(){
    String [] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    for (String bDN : beanDefinitionNames){
        applicationContext.getBeanDefinition(bDN);
        BeanDefinition beanDefinition = applicationContext.getBeanDefinition(bDN);
        if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
            System.out.println(bDN + beanDefinition);
        }
    }
}
}
