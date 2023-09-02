package com.example.tddpractice.service;

import com.example.tddpractice.domain.Member;
import com.example.tddpractice.dto.MemberDto;
import com.example.tddpractice.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceUnitTest {

  @InjectMocks MemberService memberService;

  @Mock
  MemberRepository memberRepository;

  @Test
  @DisplayName("상세조회")
  void 상세조회() {
    Long memberId = 1L;
    Long notId = 2L;
    String memberName = "John";
    Member member = Member.builder().name(memberName).build();

    when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

    assertThat(memberService.findMemberById(memberId)).isEqualTo(member);
    assertThat(memberService.findMemberById(memberId).getName()).isEqualTo(memberName);

    assertThat(memberService.findMemberById(notId)).isNull();
  }

  @Test
  @DisplayName("멤버 save")
  void save() {
    String memberName = "John";
    Member mockMember = Member.builder().name(memberName).build();
    memberService.save(mockMember);
    verify(memberRepository).save(mockMember); //실행되었는지 확인
  }








}
