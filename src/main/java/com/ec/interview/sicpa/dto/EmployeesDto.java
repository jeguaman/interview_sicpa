/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.interview.sicpa.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author J Guaman
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto implements Serializable {

    private Integer id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;
    private Integer age;
    private String email;
    private String name;
    private String position;
    private String surname;

}
