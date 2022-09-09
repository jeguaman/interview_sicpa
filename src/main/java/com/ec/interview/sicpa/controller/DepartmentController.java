/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.controller;

import com.ec.interview.sicpa.dto.DepartmentDto;
import com.ec.interview.sicpa.model.Departments;
import com.ec.interview.sicpa.service.DepartmentService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
 * @author J Guaman
 */
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @ResponseBody
    public List<DepartmentDto> getDepartments() {
        return departmentService.findAll().stream().map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(name = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DepartmentDto registerDepartment(@RequestBody DepartmentDto departmentDto) {
        Departments postRequest = modelMapper.map(departmentDto, Departments.class);
        Departments post = departmentService.createOrEdit(postRequest);
        return modelMapper.map(post, DepartmentDto.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DepartmentDto updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        Departments post = departmentService.updateDepartment(id, departmentDto);
        return modelMapper.map(post, DepartmentDto.class);
    }
}
