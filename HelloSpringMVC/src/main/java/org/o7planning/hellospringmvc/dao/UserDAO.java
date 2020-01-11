package org.o7planning.hellospringmvc.dao;

import org.o7planning.hellospringmvc.model.User;

public interface UserDAO {
	public User getUserByUsername(String username);
}