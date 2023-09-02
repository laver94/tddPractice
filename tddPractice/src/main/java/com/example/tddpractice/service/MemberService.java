package com.example.tddpractice.service;

import com.example.tddpractice.domain.Member;
import com.example.tddpractice.dto.MemberDto;
import com.example.tddpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public List<MemberDto> findDtoList() {
    return null;
  }

  public Member findMemberById(Long memberId) {
    return memberRepository.findById(memberId).orElse(null);
  }

  @Transactional
  public void save(Member mockMember) {
    memberRepository.save(mockMember);
  }
}
