package com.WAYDN.waydn.condition.domain.condition.repository;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
