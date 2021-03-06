package com.vetApplication.program.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client extends Person{

    private String details;
    private String website;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "invoice")
    private Invoice invoice;

    @OneToMany
    private List<Service> serviceList;



}
