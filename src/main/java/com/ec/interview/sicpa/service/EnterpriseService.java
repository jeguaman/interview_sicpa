/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.service;

import com.ec.interview.sicpa.dto.EnterpriseDto;
import com.ec.interview.sicpa.model.Enterprises;
import com.ec.interview.sicpa.repository.EnterpriseRepository;
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
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository repositoryEnterprise;

    public Enterprises createOrEdit(Enterprises enterprise) {
        return repositoryEnterprise.save(enterprise);
    }

    public List<Enterprises> findAll() {
        return repositoryEnterprise.findAll();
    }

    public Enterprises findEnterpriseById(Integer id) {
        Optional<Enterprises> result = repositoryEnterprise.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    public Enterprises updateEnterprises(Integer id, EnterpriseDto enterpriseDto) {
        Enterprises enterprises = findEnterpriseById(id);
        if (enterprises != null) {
            BeanUtils.copyProperties(enterpriseDto, enterprises, "id", "createdBy", "createdDate");
        }
        return createOrEdit(enterprises);
    }

}
