package com.cg.membermanipulation.MemberManipulation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.membermanipulation.MemberManipulation.controller.MemberController;
import com.cg.membermanipulation.MemberManipulation.exception.AddressNotValidException;
import com.cg.membermanipulation.MemberManipulation.model.Member;
import com.cg.membermanipulation.MemberManipulation.repository.MemberRepository;

@SpringBootTest
class MemberManipulationApplicationTests {
	
	@Autowired
	MemberController memberController;
	
	@MockBean
	MemberRepository memberRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void viewAllMembersTest() {
		when(memberRepo.findAll()).thenReturn(Stream
				.of(new Member(222,"Ram","Karnataka"), new Member(221,"Sham","Mumbai")).collect(Collectors.toList()));
		assertEquals(2, memberController.viewAllMembers().size());
	}
	
	@Test
	public void viewMembersByAddressTest() throws AddressNotValidException {
		String address = "Karnataka";
		when(memberRepo.viewMembersByAddress(address))
				.thenReturn(Stream.of(new Member(222,"Ram","Karnataka")).collect(Collectors.toList()));
		assertEquals(1, memberController.viewMembersByAddress(address).size());
	}
	
	@Test
	public void saveUserTest() {
		Member member = new Member(333,"Bhuvi","Kerala");
		when(memberRepo.save(member)).thenReturn(member);
		assertEquals(member, memberController.addMember(member));
	}
	
//	@Test
//	void testAddMember() {
//		Member member = new Member(111,"Natasha","Gujarat");
//
//		
//		memberRepo.save(member);
//		
//		// check if the data save into database or not by using assertEquals(actual value, expected value)
//		assertEquals(111, member.getMemberId());
//		assertNotNull(memberRepo);
//		
//		//check if the repository is empty or not by checking the size of the list
//		List<Member> list = memberRepo.findAll();
//		assertThat(list).size().isGreaterThan(0);
//		
//		
//	}
	
	


}
