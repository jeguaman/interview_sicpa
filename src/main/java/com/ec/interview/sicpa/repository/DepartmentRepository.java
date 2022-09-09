/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.repository;

import com.ec.interview.sicpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author J Guaman
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
