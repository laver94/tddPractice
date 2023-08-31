package com.example.tddpractice.controller;

import com.example.tddpractice.domain.Member;
import com.example.tddpractice.dto.MemberDto;
import com.example.tddpractice.service.MemberService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
class MemberControllerUnitTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  MemberService memberService;

  @Test
  @DisplayName("멤버 전체조회 테스트")
  void 멤버_전체조회_테스트() throws Exception {
    //서비스 로직
    List<MemberDto> memberDtoList = new ArrayList<>();
    Member member = Member.builder().name("John").build();
    MemberDto memberDto = MemberDto.memberToDto(member);
    memberDto.setId(1L);
    memberDtoList.add(memberDto);

    given(memberService.findDtoList()).willReturn(memberDtoList);

    mockMvc.perform(get("/api/members"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.count").value(1))
            .andExpect(jsonPath("$.data.[0].name").value("John"));

  }




}
