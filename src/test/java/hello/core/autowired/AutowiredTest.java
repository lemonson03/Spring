package hello.core.autowired;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

@Test
    void autowiredoption(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

}
static class TestBean{
@Autowired(required = false)
    public void nobean(Member member){
    System.out.println(member);
}
@Autowired(required = false)
    public void nobean2(@Nullable Member member2){
    System.out.println(member2);
}
@Autowired(required = false)
    public void nobean3(Optional<Member>  member3){
    System.out.println(member3);
}

}
}
