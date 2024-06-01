package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repositories.DepartmentRepositoru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepositoru departmentRepositoru;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepositoru.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return departments.stream()
                .map(DepartmentDTO::new)
                .toList();
    }
}
