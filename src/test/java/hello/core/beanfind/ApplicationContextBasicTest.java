package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("find by name")
    void testFindByName() {
        MemberService memberService = applicationContext.getBean("MemberService", MemberService.class);
        System.out.println(memberService);
        System.out.println(memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("find by name")
    void testFindByName2() {
        MemberService memberService = applicationContext.getBean(MemberServiceImpl.class);
        System.out.println(memberService);
        System.out.println(memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

}
