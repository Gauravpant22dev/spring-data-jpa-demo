package com.example.SpringDataJpa.Reposatiary;

import com.example.SpringDataJpa.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository <User,Long>{
}
