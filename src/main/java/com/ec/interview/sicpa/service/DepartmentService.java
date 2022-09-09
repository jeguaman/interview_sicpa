/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.model.Department;
import com.ec.interview.sicpa.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J Guaman
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repositoryDepartment;

    public Department createOrEdit(Department department) {
        return repositoryDepartment.save(department);
    }

    public List<Department> findAll() {
        return repositoryDepartment.findAll();
    }

    public Department findDepartmentById(Integer id) {
        Optional<Department> result = repositoryDepartment.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
