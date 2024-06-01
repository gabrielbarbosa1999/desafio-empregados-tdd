package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repositories.DepartmentRepository;
import com.devsuperior.demo.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return employees.map(EmployeeDTO::new);
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return new EmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO employeeDTO) {
        Department department = departmentRepository.getReferenceById(employeeDTO.getDepartmentId());
        Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getEmail(), department);
        return new EmployeeDTO(employeeRepository.save(employee));
    }
}
