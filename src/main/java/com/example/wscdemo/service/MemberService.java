package com.example.wscdemo.service;

import com.example.wscdemo.entity.Member;
import com.example.wscdemo.exception.ResourceNotFoundException;
import com.example.wscdemo.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@NoArgsConstructor
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<com.example.wscdemo.entity.Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public com.example.wscdemo.entity.Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found"));
    }

    public com.example.wscdemo.entity.Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public com.example.wscdemo.entity.Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        member.setMemberName(memberDetails.getMemberName());
        member.setEmail(memberDetails.getEmail());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        memberRepository.delete(member);
    }
}
