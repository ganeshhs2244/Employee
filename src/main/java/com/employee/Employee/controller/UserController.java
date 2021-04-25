package com.employee.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee.entity.User;
import com.employee.Employee.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController
{
	@Autowired
	private UserService userService;  
	/*
	 * GetAll User list
	 */
	@GetMapping("/getUser")
	public List<User> getEmployees()
	{
		List<User> employees = userService.getAllUser();
		return employees;
	}
	/*
	 * Add new User
	 */
	@PostMapping("/addUser")
	public void SaveUser(@RequestBody User user) 
	{
		userService.addUser(user);
	}
	/*
	 * Get User by ID
	 */
	@GetMapping("/getUser/{UserId}")
	public Optional<User> GetUSerById(@PathVariable long UserId)
	{
		Optional<User> user=userService.getUserById(UserId);
		return user;
	}
	/*
	 * Delete User
	 */
	@DeleteMapping("/delete/{userId}")
	public String DeleteUser(@PathVariable long userId)
	{
		
		Optional<User> user = userService.getUserById(userId);		
		if(user == null)
		{
		return "Employee ID not found , Id : "+userId;
		}
		else
		{
			userService.deleteUser(userId);
			return "Employee Deleted, ID : "+userId;
		}
	}
	/*
	 * Update User
	 * 
	 */
	@PutMapping("/update/{userId}")
	public void UpdateUser(@PathVariable Long userId, @RequestBody User user)
	{
		userService.updateUser(userId, user);	
	}
}
