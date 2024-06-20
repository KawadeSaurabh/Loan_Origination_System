package com.backend.LOS.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LOS.DTO.UserDTO;
import com.backend.LOS.Entity.User;
import com.backend.LOS.Repository.UserRepository;
import com.backend.LOS.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		return modelMapper.map(userRepository.registerUser(user), UserDTO.class);
	}

	@Override
	public UserDTO getUserbyId(long userId) {
		return modelMapper.map(userRepository.getUserbyId(userId), UserDTO.class);
	}

	@Override
	public UserDTO updateUser(long id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
