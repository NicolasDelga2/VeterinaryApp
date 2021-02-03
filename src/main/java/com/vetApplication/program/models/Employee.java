package com.vetApplication.program.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person{

    @ManyToOne
    @JoinColumn(name = "employeeType", insertable = false,updatable = false)
    private EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;


    private String photo;
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
