package com.dev.managementStudents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.managementStudents.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
