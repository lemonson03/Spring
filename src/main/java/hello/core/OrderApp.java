package hello.core;

import hello.core.discount.Order;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
       OrderService orderService =  applicationContext.getBean("orderService",OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order.calculatePrice());
    }
}
