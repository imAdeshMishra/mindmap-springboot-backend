package com.project.mindmap.dao;

import com.project.mindmap.entities.user.UserCredentials;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialsRepo extends CrudRepository<UserCredentials,Integer> {

    UserCredentials existsByEmailId(String emailId);
    UserCredentials findByEmailId(String emailId);
    UserCredentials findByUserId(String userId);
}
