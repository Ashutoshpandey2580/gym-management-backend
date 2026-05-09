package com.ashutosh.gymbackend.controller;

import com.ashutosh.gymbackend.entity.Member;
import com.ashutosh.gymbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

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
            @RequestParam int size,
            @RequestParam String sortBy
    ){
        return memberService.getMember(
                page,
                size,
                sortBy
        );
    }
    @GetMapping("/search")
    public List<Member> searchMember(
            @RequestParam String name
    ){
        return memberService
                .searchMember(name);
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