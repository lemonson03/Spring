package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllBeanTest {
@Test
    void findAllBean(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L,"A", Grade.VIP);
    int dicountPrice = discountService.discount(member,1000, "fixDiscountPolicy");

    Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    Assertions.assertThat(dicountPrice).isEqualTo(100);

}
static class DiscountService{
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policyMap2;

    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyMap2) {
        this.policyMap = policyMap;
        this.policyMap2 = policyMap2;
        System.out.println(policyMap);

        System.out.println(policyMap2);
    }
    public int discount(Member member, int dicountPrice, String policyName) {

       DiscountPolicy discountPolicy = policyMap.get(policyName);
       return discountPolicy.discount(member,dicountPrice);
    }
}

}
