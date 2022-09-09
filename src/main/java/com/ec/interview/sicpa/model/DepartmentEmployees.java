/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author J Guaman
 */
@Entity
@Data
public class DepartmentEmployees implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;
    @ManyToOne
    //@JoinColumn(name = "id_department", referencedColumnName = "id")
    @JoinColumn(name = "id_department", referencedColumnName = "id")
    private Department idDepartment;
    @ManyToOne
    //@JoinColumn(name = "id_employee", referencedColumnName = "id")
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employees idEmployee;

}
