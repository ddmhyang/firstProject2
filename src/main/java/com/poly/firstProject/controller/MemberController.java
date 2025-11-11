package com.poly.firstProject.controller;

import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor // Service 주입
public class MemberController {

    private final MemberService memberService;

    // 1. 회원가입 폼 페이지
    @GetMapping("/members/join")
    public String joinForm() {
        return "member/join"; // 6단계에서 만들 .mustache 파일
    }

    // 2. 회원가입 처리 (Create)
    @PostMapping("/members/create")
    public String createMember(MemberForm form) {
        memberService.join(form);
        return "redirect:/"; // 가입 후 메인 페이지로
    }

    // 3. 회원 목록 (Read - List) ...
    // 4. 회원 상세 (Read - Detail) ...
    // 5. 수정 ...
    // 6. 삭제 ...
}