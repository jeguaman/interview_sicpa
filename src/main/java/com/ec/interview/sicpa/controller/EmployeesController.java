/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.controller;

import com.ec.interview.sicpa.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jguaman
 */
@RestController
@RequestMapping("/api/employess")
public class EmployeesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeService employessService;

    
}
