package com.example.tddpractice.service;

import com.example.tddpractice.dto.MemberDto;
import com.example.tddpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public List<MemberDto> findDtoList() {
    return null;
  }
}
