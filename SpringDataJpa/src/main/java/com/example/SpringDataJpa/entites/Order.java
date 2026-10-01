package com.example.SpringDataJpa.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




    @Entity
    @NoArgsConstructor
    @Table(name = "orders")
    @Getter
    @Setter
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Getter
        @Setter
        private String productName;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="userId")
        private User user;
    }

