package com.backend.LOS.Repository;

import com.backend.LOS.DTO.UserDTO;
import com.backend.LOS.Entity.User;

public interface UserRepository {
	public User registerUser(User user);
	
	public User getUserbyId(long id);
	
	public User updateUser(long id, User user);
}
