package hello.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

public class ComponentFilterAppConfigTest {

@Test
    void filterscan(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(CompoentFilterAppConfig.class);

    ac.getBean(BeanA.class);
  //  ac.getBean(BeanB.class); 제외한거니까 exception 터짐

}
@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyincludeComponent.class),
excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = MyexcludeComponent.class )
)
static class CompoentFilterAppConfig
{

}
}
