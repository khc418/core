package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(); // 추상화에도 의존하고 구체화한것에도 의존하게된다. DIP위반

    @Test
    void join(){
        //given ~주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when ~를 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then ~게 된다
        Assertions.assertThat(member).isEqualTo(findMember); // member가 findMember와 똑같은가?

    }
}
