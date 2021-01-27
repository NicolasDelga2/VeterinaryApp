package com.vetApplication.program.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false,updatable = false)
    private Location location;
    private Integer locationId;

    private String details;
    private String website;
}
