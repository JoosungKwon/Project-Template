package com.prgrms.demotemplate.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prgrms.demotemplate.domain.user.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
