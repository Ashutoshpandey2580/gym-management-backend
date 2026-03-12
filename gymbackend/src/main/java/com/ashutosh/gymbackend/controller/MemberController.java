package com.ashutosh.gymbackend.controller;

import com.ashutosh.gymbackend.entity.Member;
import com.ashutosh.gymbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @GetMapping
    public Page<Member> getMembers(
            @RequestParam int page,
            @RequestParam int size){
        return memberService.getMembers(page,size);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,@RequestBody Member member){
        return memberService.updateMember(id,member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

}