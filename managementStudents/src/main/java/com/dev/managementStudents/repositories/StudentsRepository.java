package com.dev.managementStudents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.managementStudents.entities.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {

}
