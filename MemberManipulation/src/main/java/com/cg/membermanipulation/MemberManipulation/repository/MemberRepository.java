package com.cg.membermanipulation.MemberManipulation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.membermanipulation.MemberManipulation.model.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, Integer> {
	@Query("{address:'?0'}")
	List<Member> viewMembersByAddress(String address);
}
