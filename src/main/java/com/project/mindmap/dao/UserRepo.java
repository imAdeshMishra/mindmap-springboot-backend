package com.project.mindmap.dao;

import com.project.mindmap.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserInfo,Integer> {
    boolean existsByUserId(String userId);
    UserInfo findByUserId(String userId);
    boolean existsByEmailId(String emailId);

}
