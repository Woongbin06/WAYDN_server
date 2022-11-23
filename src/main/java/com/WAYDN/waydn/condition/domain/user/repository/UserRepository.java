package com.WAYDN.waydn.condition.domain.user.repository;

import com.WAYDN.waydn.condition.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :email")
    public Optional<User> findByEmail(@Param("email") String email);

    @Query("select u from User u where u.name = :name")
    public Optional<User> findByName(@Param("name") String name);
}