package com.backend.LOS.Service;

import com.backend.LOS.DTO.UserDTO;
import com.backend.LOS.Entity.User;

public interface UserService {
	public UserDTO registerUser(UserDTO userDTO);

	public UserDTO getUserbyId(long id);
	public UserDTO updateUser(long id, UserDTO userDTO);
}
