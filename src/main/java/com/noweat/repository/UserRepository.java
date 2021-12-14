package com.noweat.repository;

import com.noweat.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>,
                                        QuerydslPredicateExecutor<UserEntity> {
}
