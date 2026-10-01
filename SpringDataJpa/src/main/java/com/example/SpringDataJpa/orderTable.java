package com.example.SpringDataJpa;
import  com.example.SpringDataJpa.entites.User;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;



@Entity


public class orderTable {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String productName;


}

