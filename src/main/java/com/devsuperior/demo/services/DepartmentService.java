package com.devsuperior.demo.services;

import com.devsuperior.demo.repositories.DepartmentRepositoru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepositoru departmentRepositoru;

}
