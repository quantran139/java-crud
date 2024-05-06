package com.demoCRUD2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoCRUD2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
