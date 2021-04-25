package com.employee.Employee;

import java.util.ArrayList;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.employee.Employee.controller.UserController;
import com.employee.Employee.entity.User;
import com.employee.Employee.service.UserService;


import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

import javax.management.relation.Role;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = UserController.class)
class EmployeeApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@BeforeEach
	private void createMockObject()
	{
	}

	/*
	 * Test case for getting all users
	 */
	@Test
	void getAllUsersTest() throws Exception
	{

		User mockUser;
		List<User> users=new ArrayList<User>();

		mockUser = new User();
		mockUser.setFirstName("FirstName");
		mockUser.setLastName("lastName");
		mockUser.setMiddleName("middleName");

		
		users.add(mockUser);

		given(userService.getAllUser()).willReturn(users);

		this.mockMvc.perform(get("/api/getUser").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(users.size())));
	
	}

	/*
	 * Test case for getting one User
	 */
	@Test
	void getUserTest() throws Exception {
		final long id = 766L;
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");

		given(userService.getUserById(id)).willReturn(Optional.of(user));

		this.mockMvc.perform(get("/api/getUser/{id}", id).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.firstName", is(user.getFirstName())));
	}

	/*
	 * Test case for Create new User
	 */
	
	/*
	 * Test case for Deleting User
	 */
	@Test
	void deleteUserTest() throws Exception {
		Optional<User> optuser = userService.getUserById(766L);
		User user = null;
		if (optuser.isPresent()) {
			user = optuser.get();
		}

		userService.deleteUser(766L);

		Optional<User> resultUser = userService.getUserById(766L);

		assertFalse(resultUser.isPresent());
	}

	/*
	 * Test Case for Update User
	 */
	@Test
	void updateUserTest() {

	}
}
