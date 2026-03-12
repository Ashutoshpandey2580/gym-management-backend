package com.ashutosh.gymbackend.service;

import com.ashutosh.gymbackend.entity.Member;
import com.ashutosh.gymbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    // save means insert data
    public Member saveMember(Member member){
        return memberRepository.save(member);
    }
    // find all means fetch all records
    public List<Member> getAll(){
        return memberRepository.findAll();
    }
// for get records
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    // add some more method
    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElse(null);

    }
    // for update records
    public Member updateMember(Long id,Member member) {
        Member existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            existingMember.setName(member.getName());
            existingMember.setEmail(member.getEmail());
            existingMember.setPhone(member.getPhone());
            return memberRepository.save(existingMember);
        }
        return null;
    }
    // for delete records
    public void deleteMember(Long id){
        memberRepository.deleteById(id);

    }
    public Page<Member> getMembers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page,size));
    }


}
