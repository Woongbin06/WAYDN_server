package com.WAYDN.waydn.condition.domain.user.repository;

import com.WAYDN.waydn.condition.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
