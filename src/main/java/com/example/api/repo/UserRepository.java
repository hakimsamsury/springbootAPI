package com.example.api.repo;

import com.example.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    @Query("select count(e)>0 from User e where e.username = ?1 ")
    Boolean usernameExist(String username);

    @Query("select count(e)>0 from User e where e.password = ?1 ")
    Boolean passwordExist(String password);

    @Query("select e from User e where e.username = ?1 ")
    User findByUsername(String username);

}


