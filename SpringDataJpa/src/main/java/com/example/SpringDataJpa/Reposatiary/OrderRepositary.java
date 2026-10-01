package com.example.SpringDataJpa.Reposatiary;
import com.example.SpringDataJpa.entites.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositary extends JpaRepository<Order,Long> {
}
