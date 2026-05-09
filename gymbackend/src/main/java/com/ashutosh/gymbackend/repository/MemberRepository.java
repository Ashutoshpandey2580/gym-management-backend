package com.ashutosh.gymbackend.repository;

import com.ashutosh.gymbackend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member>findByNameContaining(
            String name
    );
}