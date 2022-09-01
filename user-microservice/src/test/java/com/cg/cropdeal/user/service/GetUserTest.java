package com.cg.cropdeal.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropdeal.user.model.Address;
import com.cg.cropdeal.user.model.Bank;
import com.cg.cropdeal.user.model.User;
import com.cg.cropdeal.user.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {GetUserTest.class})
public class GetUserTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;

	List<User> list=new ArrayList<>();

 	 User createUser() {
		var user=new User();
		user.setUserId((long)111);
		user.setUserName("Harry123");
		user.setUserType("Dealer");
		user.setUserId((long) 111);
		user.setUserFullName("Harry potter");
		user.setEmailId("harry@gmail.com");
		user.setPassword("hp@123");
		user.setMobileNo((long) 979876577);
		var bank =new Bank();
	    bank.setAccountHolderName("Harry potter");
		bank.setAccountNo((long)1324038664);
		bank.setBankBranch("Dublin");
		bank.setBankIFSC("BOA78754485");
		bank.setBankName("Bank of America");
		var add=new Address();
	    add.setCity("Boston");
	    add.setCountry("America");
	    add.setState("Georgia");
	    add.setHouseNo("2");
	    add.setLocalityName("Wilson Area");
	    add.setPincode(921034);
	    
	    add.setStreetName("Wilson Street");
		
	    user.setBank(bank);
	    user.setAddress(add);
		return user;
	}

	@Test
	void testGetUserByValidIdReturnsValidUser() {
		
		User user=createUser();
		list.add(user);
		when(userRepository.getByUserId((long) 111)).thenReturn(list.get(0));
		assertEquals(user,userService.getUser((long)111));
	}
	
	
	
	@Test
	void testForNotExistingUserIdReturnsNull() {
		

		User user=createUser();
		list.add(user);
		when(userRepository.getByUserId((long)112)).thenReturn(null);
		assertEquals(null,userService.getUser((long)112));
		
	}
	
	
	
	
	
	

}
