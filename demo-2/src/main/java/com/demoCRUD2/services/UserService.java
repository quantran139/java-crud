package com.demoCRUD2.services;

import com.demoCRUD2.models.User;

public interface UserService {
	User findByUserName(String userName);
}
