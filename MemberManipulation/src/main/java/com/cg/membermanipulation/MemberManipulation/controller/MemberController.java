package com.cg.membermanipulation.MemberManipulation.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.membermanipulation.MemberManipulation.exception.AddressNotValidException;
import com.cg.membermanipulation.MemberManipulation.exception.AlreadyExistedMemberException;
import com.cg.membermanipulation.MemberManipulation.model.Member;
import com.cg.membermanipulation.MemberManipulation.repository.MemberRepository;

import jakarta.validation.Valid;

@RestController
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	
	
	Member member = new Member();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping("/memberList")
	public List<Member> viewAllMembers(){
		return memberRepository.findAll(); 
	}
	
	@PostMapping("/memberList/add")
	public Member addMember(@RequestBody @Valid Member memObj) 
//			throws AlreadyExistedMemberException
	{
		
//		if((memberRepository.existsById(member.getMemberId()))){
//			return memberRepository.save(memObj);
//		}else {
//			throw new AlreadyExistedMemberException("Member already exists");
//		}
		LOGGER.info("Member added");
		return memberRepository.save(memObj);
		
		
	}
	
	@GetMapping("/memberList/{address}")
	public List<Member> viewMembersByAddress(@PathVariable(value = "address" ) String address) throws AddressNotValidException{
		
		List<Member> viewMembersByAddress = memberRepository.viewMembersByAddress(address);
		if(viewMembersByAddress.isEmpty()) {
			throw new AddressNotValidException(address+" Address not found ");
		}else {
			return memberRepository.viewMembersByAddress(address);
		}
//		return memberRepository.viewMembersByAddress(address);
	}

	

	
	 
	
}
