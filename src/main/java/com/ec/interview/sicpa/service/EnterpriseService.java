/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.model.Enterprises;
import com.ec.interview.sicpa.repository.EnterpriseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J Guaman
 */
@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository repositoryEnterprise;

    public void create(Enterprises enterprise) {
        repositoryEnterprise.save(enterprise);
    }

    public Enterprises edit(Enterprises enterprise) {
        return repositoryEnterprise.saveAndFlush(enterprise);
    }

    public List<Enterprises> findAll() {
        return repositoryEnterprise.findAll();
    }

}
