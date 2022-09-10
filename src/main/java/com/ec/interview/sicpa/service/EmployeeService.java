/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.dto.EmployeesDto;
import com.ec.interview.sicpa.model.Employees;
import com.ec.interview.sicpa.repository.EmployeesRepository;
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
public class EmployeeService {

    @Autowired
    private EmployeesRepository repositoryEmployee;

    public Employees createOrEdit(Employees employee) {
        return repositoryEmployee.save(employee);
    }

    public List<Employees> findAll() {
        return repositoryEmployee.findAll();
    }

    public Employees findDepartmentById(Integer id) {
        Optional<Employees> result = repositoryEmployee.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    public Employees updateEmployess(Integer id, EmployeesDto employeeDto) {
        Employees employess = findDepartmentById(id);
        if (employess != null) {
            BeanUtils.copyProperties(employeeDto, employess, "id", "createdBy", "createdDate");
        }
        return createOrEdit(employess);
    }

}
