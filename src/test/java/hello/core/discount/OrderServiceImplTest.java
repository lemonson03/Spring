package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
@Test
    void createOrder(){
     MemoryMemberRepository memberRepository = new MemoryMemberRepository();
     memberRepository.save(new Member(1L,"1", Grade.VIP));
    OrderService orderServiceImpl =  new OrderServiceImpl(memberRepository ,new FixDiscountPolicy() );
    orderServiceImpl.createOrder(1L, "dr", 10);
}
}