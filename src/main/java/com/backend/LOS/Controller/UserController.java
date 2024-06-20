package com.backend.LOS.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LOS.DTO.UserDTO;
import com.backend.LOS.ExceptionHandling.ResourceAlreadyExistsException;
import com.backend.LOS.ExceptionHandling.ResourceNotFoundException;
import com.backend.LOS.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<Object> registerUser(@RequestBody @Valid UserDTO userDTO) {
		try {
			return new ResponseEntity<Object>(userService.registerUser(userDTO), HttpStatus.CREATED);
		} catch (ResourceAlreadyExistsException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unexpected Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getUser(@PathVariable long id) {
		try {
			return new ResponseEntity<Object>(userService.getUserbyId(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody @Valid UserDTO userDTO){
		return null;
	}
	
	
	
	
}