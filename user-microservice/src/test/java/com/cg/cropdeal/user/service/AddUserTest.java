package com.cg.cropdeal.user.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropdeal.user.model.Address;
import com.cg.cropdeal.user.model.Bank;
import com.cg.cropdeal.user.model.User;
import com.cg.cropdeal.user.repository.UserRepository;
import com.cg.cropdeal.user.service.UserService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AddUserTest.class})
 class AddUserTest {
	
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
	void testAddingUserGivesAppropriateStringOutput() {
		
		User user=createUser();
	    
		list.add(user);
		
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		String actualResult=userService.addUser(user);
		String expectedResult="user Added";
		assertEquals(expectedResult,actualResult);
	
	}
	
	@Test
	void testRepositorySaveMethod() {
		
		User user=createUser();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		assertEquals("hp@123",userRepository.save(user).getPassword());
		assertEquals("Harry123",userRepository.save(user).getUserName());
		assertEquals("harry@gmail.com",userRepository.save(user).getEmailId());
		assertEquals("Harry potter",userRepository.save(user).getUserFullName());
		
		assertEquals("Dealer",userRepository.save(user).getUserType());
		assertEquals("Bank of America",userRepository.save(user).getBank().getBankName());
		assertEquals("BOA78754485",userRepository.save(user).getBank().getBankIFSC());
		assertEquals("Wilson Street",userRepository.save(user).getAddress().getStreetName());
		assertEquals("America",userRepository.save(user).getAddress().getCountry());
		assertEquals("Wilson Area",userRepository.save(user).getAddress().getLocalityName());
		
		
	}
	
	@Test
	void testUserData() {
		
		
		User user=createUser();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		assertEquals(111,userRepository.save(user).getUserId());
	}
	
	
	@Test
	void testcount() {
		User user=createUser();
		assertEquals(0,list.size());
		list.add(user);
		assertEquals(1,list.size());
	}
	

}