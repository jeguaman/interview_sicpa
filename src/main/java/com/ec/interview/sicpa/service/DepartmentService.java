/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.dto.DepartmentDto;
import com.ec.interview.sicpa.model.Departments;
import com.ec.interview.sicpa.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
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

    public Departments createOrEdit(Departments department) {
        return repositoryDepartment.save(department);
    }

    public List<Departments> findAll() {
        return repositoryDepartment.findAll();
    }

    public Departments findDepartmentById(Integer id) {
        Optional<Departments> result = repositoryDepartment.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    public Departments updateDepartment(Integer id, DepartmentDto departmentDto) {
        Departments department = findDepartmentById(id);
        if (department != null) {
            BeanUtils.copyProperties(departmentDto, department);
//            department.setCreatedBy(departmentDto.getCreatedBy());//por si las moscas no funcione copyProperties
        }
        return createOrEdit(department);
    }
}
