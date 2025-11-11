package com.poly.firstProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "members") // <-- 1. 테이블명 'members'로 지정
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberid; // <-- 2. 'username'에서 'memberid'로 변경

    @Column
    private String password;

    @Column
    private String name; // <-- 3. 'name' 필드 추가

    @Column
    private String email; // <-- 4. 'email' 필드 추가
}