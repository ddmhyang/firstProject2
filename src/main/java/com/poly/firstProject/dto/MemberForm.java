package com.poly.firstProject.dto;

import com.poly.firstProject.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    private Long id;
    private String memberid; // <-- 'username'에서 'memberid'로 변경
    private String password;
    private String name;     // <-- 'name' 필드 추가
    private String email;    // <-- 'email' 필드 추가

    // DTO를 Entity로 변환하는 메소드 (수정)
    public Member toEntity() {
        Member member = new Member();

        member.setId(this.id);
        member.setMemberid(this.memberid); // <-- 'memberid'로 설정
        member.setPassword(this.password);
        member.setName(this.name);         // <-- 'name' 설정 추가
        member.setEmail(this.email);       // <-- 'email' 설정 추가

        return member;
    }
}