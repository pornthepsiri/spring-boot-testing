package com.example.testingdemo.service;


import com.example.testingdemo.entity.Member;
import com.example.testingdemo.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Before
    public void setUp() throws Exception {
        memberService = new MemberService(memberRepository);
    }

    @Test
    public void createMemberSuccessfully() throws Exception {
        //Arrange
        doAnswer(returnsFirstArg()).when(memberRepository).save(any(Member.class));
        Member member = new Member();
        member.setName("Cherprang");

        //Act
        Member memberResponse = memberService.createMember(member);

        //Assert
        assertThat(memberResponse.getName()).isEqualTo("Cherprang");
        verify(memberRepository).save(any(Member.class));
    }
}
