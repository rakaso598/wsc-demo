package com.example.wscdemo.repository;

import com.example.wscdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberName(String memberName);

    Optional<Member> findByEmail(String email);
}
