package com.example.SpringDataJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.SpringDataJpa.entites.User;
@Getter
@Setter
@AllArgsConstructor

public class OrderDto {
    private Long id;
        private String productName;
        private User user;


}
