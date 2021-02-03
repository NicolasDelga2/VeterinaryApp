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
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Supplier {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;
        private String address;
        private String phone;
        private String mobile;
        private String website;
        private String email;
        private String details;

        @ManyToOne
        @JoinColumn(name = "locationid" , insertable = false, updatable = false)
        private Location location;
        private Integer locationid;

        @OneToMany
        private List<Product> productList;



}
