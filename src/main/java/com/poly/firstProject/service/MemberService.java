package com.poly.firstProject.service;

import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.entity.Member;
import com.poly.firstProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * 1. 회원 가입 (Create)
     * (JPA의 save() 특성상 수정(Update) 기능도 겸함)
     */
    public Member join(MemberForm form) {
        Member member = form.toEntity();
        return memberRepository.save(member);
    }

    /**
     * 2. 회원 목록 조회 (Read - List)
     */
    public List<Member> index() {
        return (List<Member>) memberRepository.findAll();
    }

    /**
     * 3. 회원 상세 조회 (Read - Detail)
     */
    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    /**
     * 4. 회원 삭제 (Delete)  <-- 이 부분이 추가되었습니다!
     */
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}