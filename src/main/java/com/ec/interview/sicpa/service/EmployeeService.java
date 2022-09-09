/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.model.Employees;
import com.ec.interview.sicpa.repository.EmployeesRepository;
import java.util.List;
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

    public void create(Employees employee) {
        repositoryEmployee.save(employee);
    }

    public Employees edit(Employees employee) {
        return repositoryEmployee.saveAndFlush(employee);
    }

    public List<Employees> findAll() {
        return repositoryEmployee.findAll();
    }

}
