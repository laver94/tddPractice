package com.example.tddpractice.controller;

import com.example.tddpractice.dto.MemberDto;
import com.example.tddpractice.dto.Result;
import com.example.tddpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/api/members")
  public ResponseEntity<Result<List<MemberDto>>> dtoList() {
    List<MemberDto> dtoList = memberService.findDtoList();
    return new ResponseEntity<>(new Result<>(dtoList.size(), dtoList), HttpStatus.OK);
  }

}
