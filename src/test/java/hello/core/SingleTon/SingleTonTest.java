package hello.core.SingleTon;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SingleTonTest {
    @Test
    @DisplayName("순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 1 조회 호출할 때마다 객체를 생성하는지
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴 적용한 객체 사용")
    void SingletonServiceTest(){
       SingleTonService s1 = SingleTonService.getInstance();
        SingleTonService s2 = SingleTonService.getInstance();
        System.out.println(s1);
        System.out.println(s2);
    }
@Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void singletoncontainerTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberservice1 = applicationContext.getBean("memberService", MemberService.class);
    MemberService memberservice2 = applicationContext.getBean("memberService", MemberService.class);

    System.out.println(memberservice1);
    System.out.println(memberservice2);
Assertions.assertThat(memberservice2).isSameAs(memberservice1);
    }
}
