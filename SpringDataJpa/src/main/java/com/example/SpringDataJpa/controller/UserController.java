package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.Reposatiary.UserRepositary;
import com.example.SpringDataJpa.dto.CreateUserdto;
import com.example.SpringDataJpa.dto.UserDto;
import com.example.SpringDataJpa.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserdto createUserdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(createUserdto));
    }
    @GetMapping
    public ResponseEntity<UserDto> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body((UserDto) userService.getUsers());
    }
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id){
//        userService.deleteUser(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    @PatchMapping ("/{id}")
    public ResponseEntity<UserDto> patchUser(@PathVariable Long id,@RequestBody CreateUserdto patchUserDto){
        return ResponseEntity.status(HttpStatus.OK).body((userService.patchUser(id,patchUserDto)));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody CreateUserdto updateUserDto){
        return ResponseEntity.status(HttpStatus.OK).body((userService.updateUser(id,updateUserDto)));
    }



}

