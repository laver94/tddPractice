package com.example.tddpractice.service;

import com.example.tddpractice.repository.MemberRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceUnitTest {

  @InjectMocks MemberService memberService;

  @Mock
  MemberRepository memberRepository;

  




}
