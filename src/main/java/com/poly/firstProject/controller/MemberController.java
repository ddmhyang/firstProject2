package com.poly.firstProject.controller;

import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.entity.Member;
import com.poly.firstProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members/join")
    public String joinForm() {
        return "member/join"; //
    }

    @PostMapping("/members/create")
    public String createMember(MemberForm form) {
        memberService.join(form);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String memberIndex(Model model) {
        List<Member> memberList = memberService.index();
        model.addAttribute("memberList", memberList);
        return "member/index";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Member member = memberService.show(id);
        model.addAttribute("showMemberItem", member);
        return "member/show";
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes mo) {
        memberService.delete(id);
        mo.addFlashAttribute("msg", "회원이 삭제되었습니다!");
        return "redirect:/members";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Member member = memberService.show(id);
        model.addAttribute("showMemberItem", member);
        return "member/edit";
    }
    @PostMapping("/members/update")
    public String update(MemberForm form) {
        Member updated = memberService.join(form);

        return "redirect:/members/" + updated.getId();
    }
}