package com.poly.firstProject.dto;

import com.poly.firstProject.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    private Long id;
    private String memberid;
    private String password;
    private String name;
    private String email;

    // DTO를 Entity로 변환하는 메소드 (수정)
    public Member toEntity() {
        Member member = new Member();

        member.setId(this.id);
        member.setMemberid(this.memberid);
        member.setPassword(this.password);
        member.setName(this.name);
        member.setEmail(this.email);

        return member;
    }
}