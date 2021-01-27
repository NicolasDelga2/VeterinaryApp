package com.vetApplication.program.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    private String dni;
    private String mobile;
    private String phone;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornDay;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false,updatable = false)
    private Location location;
    private Integer locationid;


    private String city;
    private String photo;


}
