package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountRate = 10;
    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return price* (100 - discountRate) /100;
        }
        else
            return price;
    }
}
