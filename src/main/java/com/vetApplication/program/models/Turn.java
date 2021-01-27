package com.vetApplication.program.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

public class Turn extends CommonObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTurn;

    // Ver esto!
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Time timeTurn;


    @ManyToOne
    @JoinColumn(name = "employeeid",insertable = false,updatable = false)
    private Employee employee;
    private Integer employeeid;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false,updatable = false)
    private Client client;
    private Integer clientid;

}
