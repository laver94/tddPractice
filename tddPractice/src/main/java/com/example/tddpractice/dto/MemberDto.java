package com.example.tddpractice.dto;

import com.example.tddpractice.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

  private Long id;
  private String name;

  public static MemberDto memberToDto(Member member) {
    MemberDto memberDto = new MemberDto();
    memberDto.setId(member.getId());
    memberDto.setName(member.getName());
    return memberDto;
  }
}
