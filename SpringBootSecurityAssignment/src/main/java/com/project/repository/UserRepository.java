package com.project.repository;

import com.project.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {
    @Query("SELECT u FROM user u where u.email = :email")
    user findByEmail(@Param("email") String email);
}
