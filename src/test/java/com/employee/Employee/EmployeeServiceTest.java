package com.employee.Employee;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.Employee.Dao.UserRepository;
import com.employee.Employee.entity.Roles;
import com.employee.Employee.entity.User;
import com.employee.Employee.service.UserService;


@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepo;

	/*
	 * Test for get All Users
	 */
	@Test
	public void getUsersTest() {
		List<Roles> roles = new ArrayList<Roles>();
		List<User> users = new ArrayList<User>();
		
		
		User user = new User(2L, new Date(), new Date(), "aaa", "aaaa", "aaaaa", "Ganesh@newvision", "Ritesh", "Deva",
				"Hamsbavi", "Java Devloper", new Date(), true, 1, true, roles);

		users.add(user);

		when(userRepo.findAll()).thenReturn(users);

		assertEquals(1, userService.getAllUser().size());
	}

	/*
	 * Test to get user by Id
	 */
	@Test
	public void getUserByIdTest() {
		final Long id = 2l;
		List<Roles> roles = new ArrayList<Roles>();
		User user = new User(2L, new Date(), new Date(), "aaa", "aaaa", "aaaaa", "Ganesh@newvision", "Ritesh", "Deva",
				"Hamsbavi", "Java Devloper", new Date(), true, 1, true, roles);

		when(userRepo.findById(id)).thenReturn(Optional.of(user));

		assertEquals(user, userService.getUserById(id).get());
	}

	/*
	 * Test for save user
	 */
	@Test
	public void addUserTest() {
		List<Roles> roles = new ArrayList<Roles>();
		User user = new User(2L, new Date(), new Date(), "aaa", "aaaa", "aaaaa", "Ganesh@newvision", "Ganesh", "s",
				"Hamsbavi", "Java Devloper", new Date(), true, 1, true, roles);

		when(userRepo.save(user)).thenReturn(user);

		assertEquals(user, userService.addUser(user));
	}

	/*
	 * Test for Delete User
	 */
	@Test
	public void deleteUserTest() {
		final Long id = 2l;
		userService.deleteUser(id);
		verify(userRepo, times(1)).deleteById(id);
	}

}
