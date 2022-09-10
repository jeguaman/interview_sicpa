/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.controller;

import com.ec.interview.sicpa.dto.EnterpriseDto;
import com.ec.interview.sicpa.model.Enterprises;
import com.ec.interview.sicpa.service.EnterpriseService;
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
@RequestMapping("/api/enterprises")
public class EnterprisesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping()
    @ResponseBody
    public List<EnterpriseDto> getDepartments() {
        return enterpriseService.findAll().stream().map(enterprise -> modelMapper.map(enterprise, EnterpriseDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EnterpriseDto registerDepartment(@RequestBody EnterpriseDto departmentDto) {
        Enterprises postRequest = modelMapper.map(departmentDto, Enterprises.class);
        Enterprises post = enterpriseService.createOrEdit(postRequest);
        return modelMapper.map(post, EnterpriseDto.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EnterpriseDto updateDepartment(@PathVariable Integer id, @RequestBody EnterpriseDto departmentDto) {
        Enterprises post = enterpriseService.updateEnterprises(id, departmentDto);
        return modelMapper.map(post, EnterpriseDto.class);
    }

}
