package com.dev.managementStudents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.managementStudents.entities.User;
import com.dev.managementStudents.repositories.UserRepository;

// controlador REST

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserManagement {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAllUsers(){
		List<User> result = this.userRepository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findUserById(@PathVariable Long id) {
		User result = this.userRepository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		User result = userRepository.save(user);
		return result;
	}
	
	@PutMapping("/edit/{id}")
	public void editUser(@RequestBody User user, @PathVariable Long id) {
		User userSaved = userRepository.findById(id).get();
		userSaved.setEmail(user.getEmail());
		userSaved.setPassword(user.getPassword());
		userSaved.setUsername(user.getUsername());
		userRepository.save(userSaved);
	}
	
	@DeleteMapping(value = "/{id}") 
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
}
