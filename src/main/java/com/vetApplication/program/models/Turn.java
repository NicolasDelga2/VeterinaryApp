package com.vetApplication.program.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Turn extends CommonObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTurn;

    // Ver esto!
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Time timeTurn;


    @ManyToOne
    @JoinColumn(name = "employeeid",insertable = false,updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false,updatable = false)
    private Client client;

}
