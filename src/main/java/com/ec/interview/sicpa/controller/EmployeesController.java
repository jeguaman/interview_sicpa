/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.controller;

import com.ec.interview.sicpa.dto.EmployeesDto;
import com.ec.interview.sicpa.model.Employees;
import com.ec.interview.sicpa.service.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jguaman
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeService employessService;

    @GetMapping()
    @ResponseBody
    public List<EmployeesDto> getDepartments() {
        return employessService.findAll().stream().map(enterprise -> modelMapper.map(enterprise, EmployeesDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EmployeesDto registerDepartment(@RequestBody EmployeesDto employeesDto) {
        Employees postRequest = modelMapper.map(employeesDto, Employees.class);
        Employees post = employessService.createOrEdit(postRequest);
        return modelMapper.map(post, EmployeesDto.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EmployeesDto updateDepartment(@PathVariable Integer id, @RequestBody EmployeesDto employeesDto) {
        Employees post = employessService.updateEmployess(id, employeesDto);
        return modelMapper.map(post, EmployeesDto.class);
    }

    
}
