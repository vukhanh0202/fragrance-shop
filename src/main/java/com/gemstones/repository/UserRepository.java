package com.gemstones.repository;

import com.gemstones.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findOneByUsernameAndStatus(String username, String status);
}
