package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepositoru extends JpaRepository<Department, Long> {
}
