package com.example.SpringDataJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class CreateOrderDto {
    private String productName;
}
