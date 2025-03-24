package hello.core.discount;
import org.assertj.core.api.Assertions;
import hello.core.member.Grade;
import hello.core.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
@Test
@DisplayName("VIP는 10퍼센트 할인 적용")
    void vip(){
    // given
    Member member = new Member(1L, "MemberA", Grade.VIP);
    //when
    int discount = rateDiscountPolicy.discount(member, 10000);
    //then
    Assertions.assertThat(discount).isEqualTo(9000);
}
@Test
    @DisplayName("VIP가 아니면 할인 적용 x")
void basic(){
    // given
    Member member = new Member(2L, "Memberb", Grade.BASIC);
    //when
    int discount = rateDiscountPolicy.discount(member, 10000);
    //then
    Assertions.assertThat(discount).isEqualTo(10000);
}
}