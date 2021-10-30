package com.uway.server.repository;

import com.uway.server.model.entity.User;
import com.uway.server.model.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
	
//	public List<UserAddress> findAllById(String username);
	
	List<UserAddress> findAllUserAddressByUser(User user);
	
	void deleteUserAddressById(Long id);
	
	
	
	
}
